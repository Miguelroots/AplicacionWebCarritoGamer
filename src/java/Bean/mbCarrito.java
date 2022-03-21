/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.CarritoDAOImpl;
import Dao.CarritoDao;
import Dao.DetalleOrdenDAO;
import Dao.DetalleOrdenDAOImpl;
import Dao.OrdenDAO;
import Dao.OrdenDAOImpl;
import Modelo.Carrito;
import Modelo.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author DELL
 */


@Named(value = "mbCarrito")
@ViewScoped
public class mbCarrito implements Serializable{

    /**
     * Creates a new instance of mbCarrito
     */
    private Carrito obj_Carrito;
    private Usuario usuario;
    
    public mbCarrito() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (Usuario) context.getExternalContext().getSessionMap().get("login");
        
        obj_Carrito = new Carrito();
    }

    public Carrito getObj_Carrito() {
        return obj_Carrito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setObj_Carrito(Carrito obj_Carrito) {
        this.obj_Carrito = obj_Carrito;
    }
    
    public List<Carrito> getLstCarrito(){
        CarritoDao obj_CarritoDao = new CarritoDAOImpl();
        return obj_CarritoDao.consultarCarrito();
    }
    
    public List<Carrito> getLstCarritoUsuario(){
        CarritoDao obj_CarritoDao = new CarritoDAOImpl();
        return obj_CarritoDao.consultarCarritoUsuario(usuario.getIdUsuario());
    }
    
    public void agregarCarrito(){
        CarritoDao obj_CarritoDao = new CarritoDAOImpl();
        try{
            obj_CarritoDao.agregarCarrito(obj_Carrito);
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","los datos fueron agregados correctamente"));
        }catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Msg",e.getMessage()));
        }
        obj_Carrito = new Carrito();
    }
    
    public void agregarCarritoSesion(){
        CarritoDao obj_CarritoDao = new CarritoDAOImpl();
        obj_Carrito.setIdCarrito(obj_CarritoDao.nuevoID());
        obj_Carrito.setUsuario(usuario);
        
        try{
            obj_CarritoDao.agregarCarrito(obj_Carrito);
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","los datos fueron agregados correctamente"));
        }catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Msg",e.getMessage()));
        }
        
        obj_Carrito = new Carrito();
    }
    
    public void eliminarCarrito(){
        CarritoDao obj_CarritoDao = new CarritoDAOImpl();
        
        try {
            obj_CarritoDao.eliminarCarrito(obj_Carrito);
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","los datos fueron eliminados correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Msg",e.getMessage()));
        }           
        obj_Carrito = new Carrito();
    }
    
    public void obtenerNuevoID(){
        CarritoDao obj_CarritoDao = new CarritoDAOImpl();
        obj_Carrito.setIdCarrito(obj_CarritoDao.nuevoID());
    }
}
