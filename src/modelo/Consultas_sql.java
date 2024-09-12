package modelo;

import java.sql.Statement;
import logica.Cliente;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
/**
 *
 * @author Temporal
 */
public class Consultas_sql {
    
    public boolean validar_existencia(Cliente c) throws SQLException{
        Conexion con = new Conexion();
        String sql = "select pk_usuario from tbl_usuario where pk_usuario = \'" + c.getUsuario() + "\';";
        Statement st = con.getConn().createStatement();
        ResultSet result = st.executeQuery(sql);

        if (result.next()) { 
            return result.getString("pk_usuario").equals(c.getUsuario());
        } else {
            return false; 
        }
    }
    
    public boolean iniciar_sesion(Cliente c) throws SQLException{
        Conexion con = new Conexion();
        String sql = "select pk_usuario from tbl_usuario where pk_usuario = \'" + c.getUsuario() + "\' and clave = \'" + c.getClave() +  "\';";
        Statement st = con.getConn().createStatement();
        ResultSet result = st.executeQuery(sql);

        if (result.next()) { 
            System.out.println("" + result.getString("pk_usuario").equals(c.getUsuario()));
            return result.getString("pk_usuario").equals(c.getUsuario()); //&& result.getString("clave").equals(c.getClave());
        } else {
            return false; 
        }
    }

    public boolean registrar_clientes(Cliente c) throws SQLException{
        Conexion con = new Conexion();
        String sql = "insert into tbl_usuario(pk_usuario,nombre,clave,fk_id_tbl_estado,fk_id_tbl_rol,fechaRegistro,tarjetaCredito,telefono,email,direccion) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement st = con.getConn().prepareStatement(sql);
        st.setString(1, c.getUsuario());
        st.setString(2, c.getNombre());
        st.setString(3, c.getClave());
        st.setInt(4, 1);
        st.setInt(5, 2);
        st.setString(6, c.getFecha_registro());
        st.setString(7, c.getTarjeta_credito());
        st.setString(8, c.getTelefono());
        st.setString(9, c.getEmail());
        st.setString(10, c.getDireccion());
        
        int filas_insertadas = st.executeUpdate();
        if (filas_insertadas > 0) {
            con.closeConn();
            return true;
        }
        else{
            con.closeConn();
            return false;
        }
    }
}
