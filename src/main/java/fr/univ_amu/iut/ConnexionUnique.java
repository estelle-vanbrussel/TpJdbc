package fr.univ_amu.iut;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by v16005687 on 25/09/17.
 */
public class ConnexionUnique {
    private Connection connection;
    private static ConnexionUnique instance = null;
    private static final String CONNECT_URL = "jdbc:mysql://mysql-estellevanbrussel.alwaysdata.net:3306/estellevanbrussel_mysql";
    private static final String LOGIN = "144384";
    private static final String PASSWORD = "alwaysdata";
    private ConnexionUnique() {
        try

        {
            connection = DriverManager.getConnection(CONNECT_URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };
    public static ConnexionUnique getInstance(){
        if(instance == null)
                instance = new ConnexionUnique();
        return instance;
    };
    public Connection getConnection(){return connection;};

}
