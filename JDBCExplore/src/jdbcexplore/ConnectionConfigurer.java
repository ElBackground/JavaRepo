package jdbcexplore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfigurer {
        
    private final String url, name, password;
    Connection con;
    
    public ConnectionConfigurer(String url, String name, String password) {
        this.url = url;
        this.name = name;
        this.password = password;
    }
    
    public Connection openConnection() {
        try {
            con = DriverManager.getConnection(url, name, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
            con = null;
        }
        return con;
    }
    
    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}