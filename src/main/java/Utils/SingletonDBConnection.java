package Utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static Utils.PropertyHelper.getPropertyObject;

public final class SingletonDBConnection {

    private static SingletonDBConnection instance;
    private String dbHost;
    private String dbUser;
    private String dbPassword;
    private Connection connection;

    public void getDBProperties() throws IOException {
        Properties dbProperties = getPropertyObject("src/main/resources/postgresDB.properties");
        dbHost = dbProperties.getProperty("db_url");
        dbUser = dbProperties.getProperty("db_user");
        dbPassword = dbProperties.getProperty("db_password");
    }

    public static SingletonDBConnection getInstance() {
        if (instance == null) {
            instance = new SingletonDBConnection();
        }
        return instance;
    }

    private SingletonDBConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            getDBProperties();
            this.connection = DriverManager.getConnection(dbHost, dbUser, dbPassword);
            System.out.println("Connection established");
        } catch (ClassNotFoundException | IOException | SQLException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }


}
