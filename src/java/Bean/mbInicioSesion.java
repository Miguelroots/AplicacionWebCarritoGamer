/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Modelo.Usuario;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author keysw
 */
@Named(value = "mbInicioSesion")
@SessionScoped
public class mbInicioSesion implements Serializable {

    private Usuario usuario;
    private Usuario admin;
    
    public mbInicioSesion() {
        usuario = new Usuario();
        admin = new Usuario(0, "admin", "admin", "Ecuador", "Masculino", new Date(2022, 1, 1), "1234", "Admin");
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void verificarSesion(){
        try{
            FacesContext context = FacesContext.getCurrentInstance();
            Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("login");
            
            if(us == null){
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Msg", 
                        "No se ha logoneado en la APP"));
                context.getExternalContext().redirect("faces/Usuario.xhtml");
                
            }else{
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Msg", 
                        "Bienvenido a la APP"));
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void verificarSesionAdmin(){
        try{
            FacesContext context = FacesContext.getCurrentInstance();
            Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("login");
            
            if(us != null && (us.getNickname() == admin.getNickname() && us.getContrasena() == admin.getContrasena())){
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Msg", 
                        "Bienvenido Administrador"));
            }else{
                context.getExternalContext().redirect("faces/AccesoDenegado.xhtml");
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    
    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().replace("login", null);
        usuario = new Usuario();
        
        return "Cerrar Sesion";
    }
    
    public String sesionIniciada(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(context.getExternalContext().getSessionMap().get("login") != null){           
            return "d-flex";
        }else{
            return "d-none";
        }
       
    }
    
    public String sesionNoIniciada(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(context.getExternalContext().getSessionMap().get("login") !=  null){
            return "d-none";
        }else{
            return "d-flex";
        }
    }
    
    public void puedeAgregarProducto(){
        
        try{
            FacesContext context = FacesContext.getCurrentInstance();
            Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("login");
            
            if(context.getExternalContext().getSessionMap().get("login") == null){
                /*context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Msg", 
                        "No se ha logoneado en la APP"));*/
                context.getExternalContext().redirect("faces/Usuario.xhtml");
                
            }else{
                /*context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Msg", 
                        "Bienvenido a la APP"));*/
                //context.getExternalContext().redirect("Carrito.xhtml");
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
}
