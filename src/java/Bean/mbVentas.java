/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.VentasDAOImpl;
import Dao.VentasDao;
import Modelo.Orden;
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
@Named(value = "mbVentas")
@ViewScoped
public class mbVentas implements Serializable {
    
    private Orden obj_Ventas;
    private List<Orden> lstVentas;
    private List<Orden> lstVentasFiltradas;
    
    public mbVentas() {
        obj_Ventas = new Orden();
    }

    public Orden getObj_Ventas() {
        return obj_Ventas;
    }

    public void setObj_Ventas(Orden obj_Ventas) {
        this.obj_Ventas = obj_Ventas;
    }

    public List<Orden> getLstVentasFiltradas() {
        return lstVentasFiltradas;
    }

    public void setLstVentasFiltradas(List<Orden> lstVentasFiltradas) {
        this.lstVentasFiltradas = lstVentasFiltradas;
    }
    
    public List<Orden> getLstVentas(){
        VentasDao obj_VentasDao = new VentasDAOImpl();
        lstVentas = obj_VentasDao.consultarVentas();
        return lstVentas;
        
    }
//    public List<Orden> getLstVentasUsuario(int id_VentUsu){
//         VentasDao obj_VentasDao = new VentasDAOImpl();
//        return obj_VentasDao.consultarVentasUsuario(id_VentUsu);
//    }
//    
//    public List<Orden> getLstVentasMetodoPago(int id_VentPag){
//         VentasDao obj_VentasDao = new VentasDAOImpl();
//        return obj_VentasDao.consultarVentasMetodoPago(id_VentPag);
//    }
//     
//        
//    public List<Orden> getLstVentasEnvio(int id_VentEnv){
//        VentasDao obj_VentasDao = new VentasDAOImpl();
//        return obj_VentasDao.consultarVentasEnvio(id_VentEnv);
//    }
    
    public void agregarVentas(){
        VentasDao obj_VentasDao = new VentasDAOImpl();
        try {
            obj_VentasDao.agregarVentas(obj_Ventas);
            obj_Ventas = new Orden();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","Los datos fueron ingresados correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Msg",e.getMessage()));
        }           
        
        obj_Ventas = new Orden();
    }
    public void modificarVentas(){
        VentasDao obj_VentasDao = new VentasDAOImpl();
        try {
            obj_VentasDao.modificarVentas(obj_Ventas);
            obj_Ventas = new Orden();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","Los datos fueron modificado correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Msg",e.getMessage()));
        }           
        
        obj_Ventas = new Orden();
    }
    public void eliminarVentas(){
        VentasDao obj_VentasDao = new VentasDAOImpl();
        try {
            obj_VentasDao.eliminarVentas(obj_Ventas);
            obj_Ventas = new Orden();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","los datos fueron eliminados correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Msg",e.getMessage()));
        }           
        
        obj_Ventas = new Orden();
    }
    
}
