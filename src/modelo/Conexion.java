package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Temporal
 */
public class Conexion {
    String url = "jdbc:mysql://localhost:3306/dbs_mercado_amigo"; 
    String usuario = "root"; 
    String contraseña = "admin"; 
    Connection conn;

    public Conexion(){
        try {
            conn = DriverManager.getConnection(url, usuario, contraseña);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void closeConn() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public Connection getConn() {
        return conn;
    }

    
    
}
