package Modelo;
// Generated 3 mar. 2022 17:58:56 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private int idUsuario;
     private String nombre;
     private String apellido;
     private String pais;
     private String sexo;
     private Date fechaNacimiento;
     private String contrasena;
     private String nickname;
     private Set<Carrito> carritos = new HashSet<Carrito>(0);
     private Set<Envio> envios = new HashSet<Envio>(0);
     private Set<Orden> ordens = new HashSet<Orden>(0);

    public Usuario() {
    }
	
    public Usuario(int idUsuario, String nombre, String apellido, String pais, String sexo, Date fechaNacimiento, String contrasena, String nickname) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasena = contrasena;
        this.nickname = nickname;
    }
    public Usuario(int idUsuario, String nombre, String apellido, String pais, String sexo, Date fechaNacimiento, String contrasena, String nickname, Set<Carrito> carritos, Set<Envio> envios, Set<Orden> ordens) {
       this.idUsuario = idUsuario;
       this.nombre = nombre;
       this.apellido = apellido;
       this.pais = pais;
       this.sexo = sexo;
       this.fechaNacimiento = fechaNacimiento;
       this.contrasena = contrasena;
       this.nickname = nickname;
       this.carritos = carritos;
       this.envios = envios;
       this.ordens = ordens;
    }
   
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getPais() {
        return this.pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getContrasena() {
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getNickname() {
        return this.nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public Set<Carrito> getCarritos() {
        return this.carritos;
    }
    
    public void setCarritos(Set<Carrito> carritos) {
        this.carritos = carritos;
    }
    public Set<Envio> getEnvios() {
        return this.envios;
    }
    
    public void setEnvios(Set<Envio> envios) {
        this.envios = envios;
    }
    public Set<Orden> getOrdens() {
        return this.ordens;
    }
    
    public void setOrdens(Set<Orden> ordens) {
        this.ordens = ordens;
    }




}


