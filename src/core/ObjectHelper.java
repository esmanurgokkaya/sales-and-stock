package core;

import interfaces.CoreInterfaces;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ObjectHelper extends CoreFields implements CoreInterfaces {


    static {
        try {
            //Class.forName("org.postgresql.Driver"); // mysql veri tabanına bağlantı sağlar
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(getUrl(),getUserName(),getPassword());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
