/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Consultas_sql;

/**
 *
 * @author Temporal
 */
public class Cliente extends Usuario{
    private String direccion;
    private String tarjeta_credito;
    private String email;
    private String telefono;
    
    public Cliente(String nombre, String usuario, String clave, String estado, String fecha_registro, 
            String direccion, String tarjeta_credito, String email, String telefono) {
        super(nombre, usuario, clave, estado, fecha_registro);
        this.direccion = direccion;
        this.email = email;
        this.tarjeta_credito = tarjeta_credito;
        this.telefono = telefono;
    }
    
    public Cliente(String usuario, String clave){
        super(usuario, clave);
    }
    
    @Override
    public void registrar() throws SQLException{
        Consultas_sql c =  new Consultas_sql();
        if (!c.validar_existencia(this)) {
            c.registrar_clientes(this);
            JOptionPane.showMessageDialog(null, "Registro exitoso.");
        }else{
            JOptionPane.showMessageDialog(null, "El usuario ya existe."); 
        }
    }
    
    @Override
    public boolean iniciar_sesion() throws SQLException{
        Consultas_sql c =  new Consultas_sql();
        if(c.validar_existencia(this)){
            if(c.iniciar_sesion(this)){
                return true;
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al iniciar sesión, usuario o clave incorrectos.");
                return false;
            }
        }else{
            JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado.");
            return false;
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTarjeta_credito() {
        return tarjeta_credito;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }
     
}

