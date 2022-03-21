/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.OrdenDAO;
import Dao.OrdenDAOImpl;
import Modelo.Orden;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author keysw
 */
@Named(value = "mbOrden")
@ViewScoped
public class mbOrden implements java.io.Serializable{

    private Orden obj_Orden;
    
    public mbOrden() {
        obj_Orden = new Orden();
    }

    public Orden getObj_Orden() {
        return obj_Orden;
    }

    public void setObj_Orden(Orden obj_Orden) {
        this.obj_Orden = obj_Orden;
    }
    
    public List<Orden> getLstOrden(){
        OrdenDAO obj_OrdenDAO = new OrdenDAOImpl();
        return obj_OrdenDAO.consultarOrden();
    }
    
    public void agregarOrden(){
        OrdenDAO obj_OrdenDAO = new OrdenDAOImpl();
        
        try{
            obj_OrdenDAO.agregarOrden(obj_Orden);
            obj_Orden = new Orden();
            FacesContext.getCurrentInstance().addMessage(null,
                   new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","Los datos fueron ingresados correctamente"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Msg",e.getMessage()));
        }        
        
        obj_Orden = new Orden();
    }
    
    public void modificarOrden(){
        OrdenDAO obj_OrdenDAO = new OrdenDAOImpl();
        
        try{
            obj_OrdenDAO.modificarOrden(obj_Orden);
            obj_Orden = new Orden();
            FacesContext.getCurrentInstance().addMessage(null,
                   new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","Los datos fueron modificados correctamente"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Msg",e.getMessage()));
        }
        
        obj_Orden = new Orden();
    }
    
    public void eliminarOrden(){
        OrdenDAO obj_OrdenDAO = new OrdenDAOImpl();
        
        try{
            obj_OrdenDAO.eliminarOrden(obj_Orden);
            obj_Orden = new Orden();
            FacesContext.getCurrentInstance().addMessage(null,
                   new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","Los datos fueron eliminados correctamente"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Msg",e.getMessage()));
        }
        
        obj_Orden = new Orden();
    }
    
}
