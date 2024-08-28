/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author Temporal
 */
abstract public class Usuario {
    private String nombre;
    private String usuario;
    private String estado;
    private String fechaRegistro; 

    public Usuario(String nombre, String usuario, String estado, String fechaRegistro) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
    }
    
    
}

