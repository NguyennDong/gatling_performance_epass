package utils;

import model.UserLinkedAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {
    private static final String DB_URL = "jdbc:oracle:thin:@//172.16.9.145:1521/umarketuat"; // Replace with your DB URL
    private static final String DB_USER = "sdk_admin"; // Replace with your username
    private static final String DB_PASSWORD = "1234567"; // Replace with your password

    public static List<UserLinkedAccount> fetchAccounts(String query) {
        List<UserLinkedAccount> accounts = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String accessToken = resultSet.getString("GETAWAY_ACCESS_TOKEN");
                String partnerAccountId = resultSet.getString("PARTNER_ACCOUNT_ID");
                String partnerCode = resultSet.getString("PARTNER_CODE");

                UserLinkedAccount account = new UserLinkedAccount(partnerAccountId, accessToken , partnerCode);

                accounts.add(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }
}
