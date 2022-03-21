/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.DetalleOrdenDAO;
import Dao.DetalleOrdenDAOImpl;
import Modelo.DetalleOrden;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author keysw
 */
@Named(value = "mbDetalleOrden")
@ViewScoped
public class mbDetalleOrden implements java.io.Serializable{

    
    private DetalleOrden obj_DetalleOrden;
    private List<DetalleOrden> lstDetalleOrdenes;
    private List<DetalleOrden> lstDetalleOrdenesFiltradas;
    
    public mbDetalleOrden() {
        obj_DetalleOrden = new DetalleOrden();
    }

    public DetalleOrden getObj_DetalleOrden() {
        return obj_DetalleOrden;
    }

    public void setObj_DetalleOrden(DetalleOrden obj_DetalleOrden) {
        this.obj_DetalleOrden = obj_DetalleOrden;
    }

    public List<DetalleOrden> getLstDetalleOrdenesFiltradas() {
        return lstDetalleOrdenesFiltradas;
    }

    public void setLstDetalleOrdenesFiltradas(List<DetalleOrden> lstDetalleOrdenesFiltradas) {
        this.lstDetalleOrdenesFiltradas = lstDetalleOrdenesFiltradas;
    }
    
    public List<DetalleOrden> getLstDetalleOrden(){
        DetalleOrdenDAO obj_DetalleOrdenDAO = new DetalleOrdenDAOImpl();
        lstDetalleOrdenes = obj_DetalleOrdenDAO.consultarDetalleOrden();
        return lstDetalleOrdenes;
    }
    
    public void agregarDetalleOrden(){
        DetalleOrdenDAO obj_DetalleOrdenDAO = new DetalleOrdenDAOImpl();
        
        try{
            obj_DetalleOrdenDAO.agregarDetalleOrden(obj_DetalleOrden);
            obj_DetalleOrden = new DetalleOrden();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","Los datos fueron ingresados correctamente"));
        }catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Msg",e.getMessage()));
        }
        
        obj_DetalleOrden = new DetalleOrden();
    }
    
    public void modificarDetalleOrden(){
        DetalleOrdenDAO obj_DetalleOrdenDAO = new DetalleOrdenDAOImpl();
        
        try{
            obj_DetalleOrdenDAO.modificarDetalleOrden(obj_DetalleOrden);
            obj_DetalleOrden = new DetalleOrden();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","Los datos fueron modificados correctamente"));
        }catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Msg",e.getMessage()));
        }    
        
        obj_DetalleOrden = new DetalleOrden();
    }
    
    public void eliminarDetalleOrden(){
        DetalleOrdenDAO obj_DetalleOrdenDAO = new DetalleOrdenDAOImpl();
        
        try{
            obj_DetalleOrdenDAO.eliminarDetalleOrden(obj_DetalleOrden);
            obj_DetalleOrden = new DetalleOrden();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","Los datos fueron eliminados correctamente"));
        }catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Msg",e.getMessage()));
        }
        
        obj_DetalleOrden = new DetalleOrden();
    }
    
    public void agregarDetalleOrdenCarrito(){
        DetalleOrdenDAO obj_DetalleOrdenDAO = new DetalleOrdenDAOImpl();
        obj_DetalleOrden.setIdDetalleOrden(obj_DetalleOrdenDAO.nuevoID());
        
        
        try{
            
        }catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Msg",e.getMessage()));
        }
    }
    
    public void obtenerNuevoID(){
        DetalleOrdenDAO obj_DetalleOrdenDAO = new DetalleOrdenDAOImpl();
        obj_DetalleOrden.setIdDetalleOrden(obj_DetalleOrdenDAO.nuevoID());
    }
    
}
