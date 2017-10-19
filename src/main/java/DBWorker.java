import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBWorker {

    private static final String URL = "jdbc:mysql://localhost:3306/Catalog_of_magazines";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private Connection connection;

    /*
    FabricMySQLDriver  - содержит в себе драйвер
    подключает БД
     */

    public DBWorker() {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.err.println("Нет соединения с базой данных");
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }
}


