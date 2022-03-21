/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.UsuarioDAOImpl;
import Dao.UsuarioDao;
import Modelo.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author DELL
 */
@Named(value = "mbUsuario")
@ViewScoped
public class mbUsuario implements Serializable {

    /**
     * Creates a new instance of mbUsuario
     */
    
    private Usuario obj_Usuario;
    private Usuario admin;
    private List<Usuario> lstUsuarios;
    private List<Usuario> lstUsuariosFiltrados;
    
    public mbUsuario() {
        obj_Usuario = new Usuario();
        admin = new Usuario(0, "admin", "admin", "Ecuador", "Masculino", new Date(2022, 1, 1), "1234", "Admin");
    }

    public Usuario getObj_Usuario() {
        return obj_Usuario;
    }

    public void setObj_Usuario(Usuario obj_Usuario) {
        this.obj_Usuario = obj_Usuario;
    }

    public List<Usuario> getLstUsuariosFiltrados() {
        return lstUsuariosFiltrados;
    }

    public void setLstUsuariosFiltrados(List<Usuario> lstUsuariosFiltrados) {
        this.lstUsuariosFiltrados = lstUsuariosFiltrados;
    }
    
    public List<Usuario> getLstUsuario(){
        UsuarioDao obj_UsuarioDao = new UsuarioDAOImpl(); // instancia al Dao o implementacion al dao
        lstUsuarios = obj_UsuarioDao.consultarUsuario();
        return lstUsuarios;
    }
    
    public void agregarUsuario(){
        UsuarioDao obj_UsuarioDao = new UsuarioDAOImpl(); 
        try {
            obj_UsuarioDao.agregarUsuario(obj_Usuario);
            obj_Usuario = new Usuario();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","Los datos fueron ingresados correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Msg",e.getMessage()));
        }
       
        obj_Usuario = new Usuario();
    }
    
    
    public void modificarUsuario(){
        UsuarioDao obj_UsuarioDao = new UsuarioDAOImpl();
        try {
            obj_UsuarioDao.modificarUsuario(obj_Usuario);
            obj_Usuario = new Usuario();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","Los datos fueron modificados correctamente"));
        } catch (Exception e) {
             FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Msg",e.getMessage()));
        }

        obj_Usuario = new Usuario();
    }
    
    public void eliminarUsuario(){
        UsuarioDao obj_UsuarioDao = new UsuarioDAOImpl();
        try {
            obj_UsuarioDao.eliminarUsuario(obj_Usuario);
            obj_Usuario = new Usuario();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","Los datos fueron eliminados correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Msg",e.getMessage()));
        }

        obj_Usuario = new Usuario();
    }
    
    public void obtenerNuevoID(){
        UsuarioDao obj_UsuarioDao = new UsuarioDAOImpl();
        obj_Usuario.setIdUsuario(obj_UsuarioDao.nuevoID());
    }
    
    
    //INICIO DE SESION
    public String iniciarSesion(){
        String pagina = "Acceso Denegado";
        UsuarioDao obj_UsuarioDao = new UsuarioDAOImpl();
        
        Usuario us = obj_UsuarioDao.iniciarSesion(obj_Usuario);
        
        if(obj_Usuario.getNickname().equals(admin.getNickname()) && 
                obj_Usuario.getContrasena().equals(admin.getContrasena())){
            pagina = "Acceso Permitido Administrador";
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("login", admin);
            return pagina;
        }else if(us != null){
            pagina = "Acceso Permitido";
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("login", us);
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Msg","Bienvenido al Sistema"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Msg","Credenciales Incorrectas"));
        }
        
        return pagina;
    }
}
