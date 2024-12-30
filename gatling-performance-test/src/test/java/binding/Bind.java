package binding;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.ApiResponse;
import model.UserLinkedAccount;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.Test;
import utils.DatabaseUtils;
import utils.KeyUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class Bind {

    Logger log = Logger.getLogger(Bind.class.getName());

    @Test(description = "Binding")
    public void Binding() {
        String inputFilePath = "src/test/resources/data/data_user_phone.csv"; // Đường dẫn tệp CSV đầu vào
        String outputFilePath = "src/test/resources/data/response.csv"; // Đường dẫn tệp CSV đầu ra
        
        //đọc data từ file và lưu sdt vào phoneNumbers
        List<String> phoneNumbers = readPhoneNumberFromFile(inputFilePath);

        bindUserPhones(outputFilePath, phoneNumbers);
    }

    @NotNull
    private static List<String> readPhoneNumberFromFile(String inputFilePath) {
        List<String> phoneNumbers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] columns = line.split(",");

                if (columns.length > 0) {
                    phoneNumbers.add(columns[0].trim());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return phoneNumbers;
    }

    private void bindUserPhones(String outputFilePath, List<String> phoneNumbers) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {

            List<UserLinkedAccount> userLinkedAccounts = new ArrayList<>();
            for (String phoneNumber : phoneNumbers) {
                List<String> list = new ArrayList<>();
                list.add(phoneNumber);

                String responseBody = executeBinding(phoneNumber, userLinkedAccounts);
                list.add(responseBody);

                bw.write(String.join(",", list));
                bw.newLine();

                System.out.println("Data has been written to " + outputFilePath);
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/resources/data/user_phone_token.csv"))){
                writer.write("phone_number,partner_client_id,getaway_access_token,rsa_token,partner_code");
                writer.newLine();
                for (UserLinkedAccount userLinkedAccount : userLinkedAccounts) {
                    writer.write(userLinkedAccount.toString());
                    writer.newLine();
                }

                log.info("data written to user_phone_token.csv");
            } catch (IOException e) {
                log.info(e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String executeBinding(String phoneNumber, List<UserLinkedAccount> userLinkedAccounts)
            throws InterruptedException, IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        String partnerCode = "MOMOV3FN20220908";
        String requestId = String.valueOf(new Date().getTime());
        String language = "en";
        String extraData = "{}";
        String version = "1.0";
        String startTime = String.valueOf(new Date().getTime());
        String caller = "gatewayV2";
        String educateBinding = "true";
        String partnerName = "Cuong Mai Kien";
        String amount = "0";
        String partnerRefId = phoneNumber;
        String partnerAccountId = phoneNumber;
        String requestType = "subscription";
        String storeId = "MOMOV3FN20220908";
        String originalAmount = "0";
        String bindingFlow = "qr";
        String limitAmount = "1000";
        String limitTransaction = "1";
        String moneySource = "1";
        String billId = String.valueOf(new Date().getTime());
        String payOneTimeToken = "false";
        String notification = "true";
        String remainingSLA = "29213";
        String customerNumber = phoneNumber;
        String partnerClientId = phoneNumber;
        String publicKeyBase64 = "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEA7PeNqf811txIGx4rcm8vuCRX4BohpIE1DAq9GDZfm54J+FAWsMPUXpaF4V8tm5gwm0wT3gso/gHJyqhOD+a4Rl4eSto/V/yXSaqfXNxpw3B983se6MYY4880AyXAJlABsPS0iDAjJWBRkq38cjkv1rcZpa1QU2tuqy8wZXxfsKoink0D8lRcRIW/bZX8j8TUok0AbYbBbr7XJUwwvnI8PNUsR6QB94OzhJeExWdTQBVr5dbkYVJgjIyFlNX3bwDGRffqVeOh8v21yBUs1345LSycLEw5sAjfhZMH88c1tKc90Wsqar4WXCy4yusdo3pQTf2TZRELHW9SD1jlqw5m+dFWbm9nWVat1Y2Kj9FoJHGtFiiOo2rkuiB/NawBUunXL6qO6UR8sEGLFRagXnwY4iCI2Z/a4MYrOwxQvRAKyHL4kM/WjeKgXmfAr+Rb2xEdg6gvU9VVCiQTRTKk2R8HKBYVJNq+CnhHtZJFYxcYxOf/GIard+SFkJhTT5GvsAgoytVLU469R/b6FX1FxljtNHS9a2xel0nIPob2NKGTyPJX6qEv3i7lgprkGLziQjjN1M7rKfkEinq648KrWCEIGyfcptu0BjVNLaf7p7kOjGkFudg49P2DGVdQdIVyey52++4qLpoKBu9rKlfpWXSg5G4odMizCQryd3G2+rXyLusCAwEAAQ==";

        String data = "{\n" +
                "    \"customerNumber\": \""+customerNumber+"\",\n" +
                "    \"requestId\": \""+requestId+"\",\n" +
                "    \"walletId\": \""+customerNumber+"\",\n" +
                "    \"pin\": \"000000\",\n" +
                "    \"partnerCode\": \""+partnerCode+"\",\n" +
                "    \"partnerAccountId\": \""+partnerAccountId+"\",\n" +
                "    \"partnerClientId\": \""+partnerClientId+"\",\n" +
                "    \"hash\": null\n" +
                "}";

        String tokenData = KeyUtils.encryptRSA(data, publicKeyBase64);

        HttpRequest.BodyPublisher body = HttpRequest.BodyPublishers.ofString(
                "{\n" +
                        "    \"partnerCode\": \""+partnerCode+"\",\n" +
                        "    \"requestId\": \""+requestId+"\",\n" +
                        "    \"language\": \""+language+"\",\n" +
                        "    \"extraData\": \""+extraData+"\",\n" +
                        "    \"version\": "+version+",\n" +
                        "    \"startTime\": "+startTime+",\n" +
                        "    \"caller\": \""+caller+"\",\n" +
                        "    \"educateBinding\": "+educateBinding+",\n" +
                        "    \"tokenData\": \""+tokenData+"\",\n" +
                        "    \"payload\": {\n" +
                        "        \"partnerCode\": \""+partnerCode+"\",\n" +
                        "        \"partnerName\": \""+partnerName+"\",\n" +
                        "        \"amount\": "+amount+",\n" +
                        "        \"partnerRefId\": \""+partnerRefId+"\",\n" +
                        "        \"partnerAccountId\": \""+partnerAccountId+"\",\n" +
                        "        \"requestType\": \""+requestType+"\",\n" +
                        "        \"storeId\": \""+storeId+"\",\n" +
                        "        \"originalAmount\": "+originalAmount+",\n" +
                        "        \"bindingFlow\": \""+bindingFlow+"\",\n" +
                        "        \"limitAmount\": "+limitAmount+",\n" +
                        "        \"limitTransaction\": "+limitTransaction+"\n" +
                        "    },\n" +
                        "    \"moneySource\": "+moneySource+",\n" +
                        "    \"billId\": \""+billId+"\",\n" +
                        "    \"payOneTimeToken\": "+payOneTimeToken+",\n" +
                        "    \"notification\": "+notification+",\n" +
                        "    \"remainingSLA\": "+remainingSLA+"\n" +
                        "}");


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://inginx-dev.mservice.io:30699/internal/pay/tokenization"))
                .POST(body)
                .header("Content-Type", "application/json")
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            userLinkedAccounts.addAll(extractData(response.body(), phoneNumber, partnerCode, publicKeyBase64));
        }
        return response.body();
    }

    private List<UserLinkedAccount> extractData(String body, String phoneNumber, String partnerCode, String publicKeyBase64) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ApiResponse apiResponse = objectMapper.readValue(body, ApiResponse.class);

            List<UserLinkedAccount> linkedAccounts = new ArrayList<>();
            if (apiResponse.getStatus() == 0 || apiResponse.getStatus() == 18) {
                String sql = "select GETAWAY_ACCESS_TOKEN, sdk_user_access_token.PARTNER_ACCOUNT_ID, sdk_user_access_token.PARTNER_CODE from SDK_ADMIN.sdk_user_access_token\n" +
                        "where PARTNER_ACCOUNT_ID = '" + phoneNumber+ "' and PARTNER_CODE = '" + partnerCode + "'";

                List<UserLinkedAccount> accounts = DatabaseUtils.fetchAccounts(sql);
                accounts.forEach(x -> {
                    x.setUserPhone(phoneNumber);
                    try {
                        x.setRsaToken(KeyUtils.encryptRSA("{\"value\": \""+x.getGetawayAccessToken()+"\"}", publicKeyBase64));
                    } catch (NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException |
                             InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
                        log.info(e.getMessage());
                        x.setRsaToken("");
                    }
                });

                linkedAccounts.addAll(accounts);
            }

            return linkedAccounts;

        } catch (JsonProcessingException e) {
            log.info("");
            return new ArrayList<>();
        }
    }
}
