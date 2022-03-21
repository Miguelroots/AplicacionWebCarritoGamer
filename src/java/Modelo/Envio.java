package Modelo;
// Generated 3 mar. 2022 17:58:56 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Envio generated by hbm2java
 */
public class Envio  implements java.io.Serializable {


    private int idEnvio;
    private Usuario usuario;
    private String pais;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String provincia;
    private String codigoPostal;
    private int telefono;
    private Set<Orden> ordens = new HashSet<Orden>(0);

    public Envio() {
    }

	
    public Envio(int idEnvio, Usuario usuario, String pais, String nombre, String direccion, String ciudad, String provincia, String codigoPostal, int telefono) {
        this.idEnvio = idEnvio;
        this.usuario = usuario;
        this.pais = pais;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.codigoPostal = codigoPostal;
        this.telefono = telefono;
    }
    public Envio(int idEnvio, Usuario usuario, String pais, String nombre, String direccion, String ciudad, String provincia, String codigoPostal, int telefono, Set<Orden> ordens) {
       this.idEnvio = idEnvio;
       this.usuario = usuario;
       this.pais = pais;
       this.nombre = nombre;
       this.direccion = direccion;
       this.ciudad = ciudad;
       this.provincia = provincia;
       this.codigoPostal = codigoPostal;
       this.telefono = telefono;
       this.ordens = ordens;
    }
   
    public int getIdEnvio() {
        return this.idEnvio;
    }
    
    public void setIdEnvio(int idEnvio) {
        this.idEnvio = idEnvio;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getPais() {
        return this.pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCiudad() {
        return this.ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getProvincia() {
        return this.provincia;
    }
    
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public String getCodigoPostal() {
        return this.codigoPostal;
    }
    
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public int getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public Set<Orden> getOrdens() {
        return this.ordens;
    }
    
    public void setOrdens(Set<Orden> ordens) {
        this.ordens = ordens;
    }




}


