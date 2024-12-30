package simulations;

import io.gatling.javaapi.core.FeederBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import utils.KeyUtils;
import utils.MerchantKeyMapper;

import java.util.Date;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class CheckBalanceSimulation extends BasicSimulation {
    {
        // Fixed parameters
        String partnerAccountId = "testing35520";
        String amount = "100000";

        // Load partnerCode from CSV file
        FeederBuilder.FileBased<String> feeder = csv("data/user_phone_token.csv").circular();

        final ScenarioBuilder scn = scenario("Check Balance")
                .feed(feeder) // Feed the partnerCode
                .exec(session -> {
                    // Get partnerCode from the session
                    String partnerCode = session.getString("partner_code");
                    String requestId = String.valueOf(new Date().getTime());

                    // Fetch merchant metadata
                    MerchantKeyMapper.MerchantData merchant = MerchantKeyMapper.getMerchantMetaData(partnerCode);

                    // Generate signature
                    String message = "accessKey=" + merchant.getAccessKey() + "&partnerCode=" + partnerCode +
                            "&requestId=" + requestId + "&amount=" + amount + "&partnerAccountId=" + partnerAccountId;
                    String signature = KeyUtils.genSignatureKey(merchant.getSecretKey(), message);

                    // Add signature and other computed data to the session
                    return session
                            .set("partnerCode", partnerCode)
                            .set("requestId", requestId)
                            .set("signature", signature);
                })
                .exec(http("Check Balance Request")
                        .post("/tokenization/traffic/check-balance")
                        .body(StringBody(session -> "{\n" +
                                "\"partnerCode\": \"" + session.getString("partnerCode") + "\",\n" +
                                "\"requestId\": \"" + session.getString("requestId") + "\",\n" +
                                //"\"partnerClientId\": \"" + partnerAccountId + "\",\n" +
                                 "\"partnerClientId\": \"" + "testing35520" + "\",\n" +
                                "\"amount\": \"" + amount + "\",\n" +
                                "\"signature\": \"" + session.getString("signature") + "\"\n" +
                                "}"))
                        .asJson()
                        .check(status().is(200))
                        .check(responseTimeInMillis().lte(200)))
                        .pause(1);

//        setUp(
//                scn.injectOpen(rampUsers(10).during(30))
//        ).protocols(httpProtocol);
        {
            /**
             * 1. Xác định khả năng xử lý ổn định của hệ thống.
             * Test: Tăng tốc độ tạo từ 1 đến 20 user mỗi giây trong 20s, sau đó 20 User gửi request liên tục trong vòng 60s
             * Sample report: file:///D:/MOMO/Gatling/gatling-maven-plugin-demo-java-main/target/gatling/checkbalance-20241227175937528/index.html
             * Dự kiến:  Tăng tốc độ tạo từ 1 đến n user mỗi giây trong 10m, User gửi request liên tục trong vòng 20m
             * Tăng dần số user + 100 qua các lần run (Dự kiến: 100, 200, 300, 400, 500)
             * Comment: ---
             */
        setUp(
                scn.injectOpen(
                        rampUsersPerSec(1).to(20).during(20),
                        constantUsersPerSec(20).during(60)
                )
        ).protocols(httpProtocol);

            /**
             * 2. Xác định throughput tối đa của hệ thống trước khi có lỗi
             * Test: Tăng tốc độ tạo từ 1 đến 20 user mỗi giây trong 2 phút.
             * Sample report: file:///D:/MOMO/Gatling/gatling-maven-plugin-demo-java-main/target/gatling/checkbalance-20241227180729823/index.html
             * Dự kiến: Tăng tốc độ tạo từ 10 đến 500 user mỗi giây trong 30 phút.
             * Comment: ---
             */
        /*setUp(
                scn.injectOpen(
                        rampUsersPerSec(1).to(20).during(120)
                )
        ).protocols(httpProtocol);*/

            /**
             * 3. Kiểm tra tăng/giảm tải đột ngột
             * Test: 1 to 10 user during 10s - 0.5s - 30 user - 10s - 30 to 5 during 30s
             * Sample report: file:///D:/MOMO/Gatling/gatling-maven-plugin-demo-java-main/target/gatling/checkbalance-20241227180211477/index.html
             * Dự kiến: 1 to 100 user during 120s - 0.5s - 300 user - 10s - 300 to 100 during 30s
             * Comment: ---
             */
        /*setUp(
                scn.injectOpen(
                        rampUsersPerSec(1).to(10).during(10), // Tăng tải từ 1 lên 10 user trong vòng 10s
                        nothingFor((long) 0.5), // Dừng lại trong 0.5 giây
                        atOnceUsers(30), // Đột ngột tăng lên 30 user
                        nothingFor(5), // Dừng lại trong 10 giây
                        rampUsersPerSec(30).to(5).during(10) // Giảm tải từ 30 -> 5 user trong vòng 30s
                )
        ).protocols(httpProtocol);*/

            /**
             * 4. Kiểm tra giới hạn tải tối đa mà hệ thống vẫn ổn định.
             * Test: increment 2 UsersPerSec, loop 10 times, eachLevelLasting 10s
             * Sample report: file:///D:/MOMO/Gatling/gatling-maven-plugin-demo-java-main/target/gatling/checkbalance-20241227181156082/index.html
             * Dự kiến: increment 10 UsersPerSec, loop 30 times, eachLevelLasting 60s
             * Comment: ---
             */
//            setUp(
//                    scn.injectOpen(
//                            incrementUsersPerSec(2) // Tăng 10 user mỗi giây
//                                    .times(10) // Duy trì trong 10 chu kỳ
//                                    .eachLevelLasting(1) // Mỗi mức tải duy trì 10s
//                    )
//            ).protocols(httpProtocol)/*.assertions(
//                global().responseTime().max().lt(20000),
//                global().successfulRequests().percent().gt(100.0)
//        )*/;
        }
    }
}
