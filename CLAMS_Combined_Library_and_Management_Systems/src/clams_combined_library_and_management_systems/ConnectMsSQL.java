package clams_combined_library_and_management_systems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConnectMsSQL {

    public void connectDB() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Clams_lms;selectMethod=cursor", "sa", "39425153");

            System.out.println("DATABASE NAME IS:"
                    + connection.getMetaData().getDatabaseProductName());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT UniqueID, Password FROM Credentials_");
            while (resultSet.next()) {
                System.out.println("Unique ID:"
                        + resultSet.getString("UniqueID") + "   Password:" + resultSet.getString("Password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
