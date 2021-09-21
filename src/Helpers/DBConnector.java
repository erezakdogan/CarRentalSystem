package Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private Connection connection;
    private String url= "jdbc:postgresql://localhost/carrental";
    private String user = "postgres";
    private String password = "postgresql";

    public Connection connectDB() {

        try {
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.connection;
    }

    public static Connection getInstance(){
        DBConnector dbConnector = new DBConnector();
        return dbConnector.connectDB();
    }
}
