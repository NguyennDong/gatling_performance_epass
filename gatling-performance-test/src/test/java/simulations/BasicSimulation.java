package simulations;

import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.http.HttpDsl.http;

public abstract class BasicSimulation extends Simulation {

    protected final HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://inginx-dev.mservice.io:30699")
            .acceptHeader("application/json")
            .contentTypeHeader("application/json");

//    {
//        String accessKey = "2qJLkxv8ysucMGBV";
//        String partnerCode = "MOMOV3FN20220908";
//        String subPartnerCode = "MOMOV3FN20220908";
//        String requestId = String.valueOf(new Date());
//        String amount = "100000";
//        String partnerAccountId = "testing35520";
//        String messageCheckBalance = "accessKey=" + accessKey + "&partnerCode=" + partnerCode + "&requestId=" + requestId + "&amount=" + amount +
//                "&partnerAccountId=" + partnerAccountId;
//        String key = "XvVpsS2We3vAqctHFuqCnU1XXOF1LT9r";
//
//        String signatureCheckBalance = signatureKeyBuilder(key, messageCheckBalance);
//
//        System.out.println("signatureCheckBalance=" + signatureCheckBalance);
//
//        final ScenarioBuilder scn = scenario("Check Balance")
//                .exec(http("Check balance query")
//                                .post("/tokenization/light/check-balance")
//                                .body(StringBody(session -> "{\n" +
//                                        "\"partnerCode\": \"" + partnerCode + "\"" +
//                                        "\"subPartnerCode\": \"" + subPartnerCode + "\"" +
//                                        "\"requestId\": \"" + requestId + "\"" +
//                                        "\"lang\":  \"en\",\n" +
//                                        "\"partnerAccountId\": \"" + partnerAccountId + "\"" +
//                                        "\"amount\":  \"" + amount + "\"" +
//                                        "\"signature\": \"" + signatureCheckBalance + "\"" +
//                                        "}")).asJson()
//                                .check(status().is(200))
//                                .check(responseTimeInMillis().lte(200))
//                )
//                .pause(1);
//        setUp(
//            scn.injectOpen(
//                    nothingFor(5),
//                    atOnceUsers(100),
//                    rampUsers(60000).during(600)
//            )
//        ).protocols(httpProtocol);
//    }
//
//    private String signatureKeyBuilder(String key, String message) {
//        return KeyUtils.genSignatureKey(key, message);
//    }
//
//    private final FeederBuilder<String> csvFeeder = csv("data.csv").circular();
//    {
//
//
//        // đọc file | đọc trực tiếp DB
//        //vòng lặp từng row
//
//        List<Map<String, Object>> records = csvFeeder.readRecords();
//        for (Map<String, Object> record : records) {
//            String accessKey = record.get("access_key").toString();
//
//
//        }
//        String accessKey = "DWMHYoN6R2lJeAgF";
//        //String orderId = "1628136002504:0123456778";
//        String partnerCode = "MOMOIOLD20190129";
//        String subPartnerCode = "MOMOIOLD20190129";
//        String requestId = "CGV19072017_1525975811";
//        String amount = "100000";
//        String partnerAccountId = "latest123";
//        //String message = "accessKey="+accessKey+"&orderId="+orderId+"&partnerCode="+partnerCode+"&requestId="+requestId;
//        String messageCheckBalance = "accessKey="+accessKey+"&partnerCode="+partnerCode+ "&requestId="+requestId+"&amount="+amount+
//                "&partnerAccountId="+partnerAccountId;
//        String key = "um76xDBeRmmj5kVMhXiCeFKixZTTlmZb";
//
//        String signatureCheckBalance = signatureKeyBuilder(key, messageCheckBalance);
//        System.out.println("signatureCheckBalance="+signatureCheckBalance);
//
//        final ScenarioBuilder scn = scenario("Check Balance")
////                .feed(records)
//                .exec(http("Check balance query")
//                        .post("/tokenization/light/check-balance")
//                        .body(StringBody(session ->"{\n" +
//                                "\"partnerCode\": \"" + partnerCode + "\"" +
//                                "\"subPartnerCode\": \"" + subPartnerCode + "\"" +
//                                "\"requestId\": \"" + requestId + "\"" +
//                                "\"lang\":  \"en\",\n" +
//                                "\"partnerAccountId\": \"" + partnerAccountId + "\"" +
//                                "\"amount\":  \"" + amount + "\"" +
//                                "\"signature\": \"" + signatureCheckBalance + "\"" +
////                                \"a66753f708967a731842fe5a41cda0c1b45f91edf9187d7f74861918c5d4af2d\"\n" +
//                                "}")).asJson()
//                        .check(status().is(200))
//                        .check(responseTimeInMillis().lte(200))
//                )
//                .pause(1);
//        setUp(
//                scn.injectOpen(
//                        nothingFor(5),
//                        atOnceUsers(10),
//                        rampUsers(1).during(60)
//                )
//        ).protocols(httpProtocol);
//    }


//    private ScenarioBuilder checkBalance = scenario("Check Balance API")
//            .exec(http("Check Balance")
//                    .get("/api/check-balance")
//                    .check(status().is(200))
//                    .check(responseTimeInMillis().lte(200))
//            );
//
//    private ScenarioBuilder initTransaction = scenario("Init Transaction API")
//            .exec(http("Init Transaction")
//                    .post("/api/init")
//                    .body(StringBody("{ \"amount\": 1000 }"))
//                    .asJson()
//                    .check(status().is(200))
//                    .check(responseTimeInMillis().lte(200))
//            );
//
//    private ScenarioBuilder confirmTransaction = scenario("Confirm Transaction API")
//            .exec(http("Confirm Transaction")
//                    .post("/api/confirm")
//                    .body(StringBody("{ \"transactionId\": \"12345\" }"))
//                    .asJson()
//                    .check(status().is(200))
//                    .check(responseTimeInMillis().lte(200))
//            );
//
//    {
//        setUp(
//                checkBalance.injectOpen(rampUsers(50).during(Duration.ofSeconds(10))),
//                initTransaction.injectOpen(constantUsersPerSec(20).during(Duration.ofSeconds(20))),
//                confirmTransaction.injectOpen(atOnceUsers(30))
//        ).protocols(httpProtocol);
//    }
}
