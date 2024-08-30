package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Temporal
 */
public class Conexion {
     // Configuración de conexión
    String url = "jdbc:mysql://localhost:3306/nombreBaseDatos"; // Reemplaza "nombreBaseDatos" por el nombre de tu base de datos
    String usuario = "root"; // Reemplaza con tu usuario de MySQL
    String contraseña = "tuContraseña"; // Reemplaza con tu contraseña de MySQL
    Connection conexion = null;

    public Conexion(){
        try {
        // Crear la conexión a la base de datos
        conexion = DriverManager.getConnection(url, usuario, contraseña);
        System.out.println("Conexión exitosa a la base de datos!");

        // Aquí puedes añadir el código para interactuar con la base de datos
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos.");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
