/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.ProductoDAO;
import Dao.ProductoDAOImpl;
import Modelo.Producto;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author keysw
 */
@Named(value = "mbProducto")
@ViewScoped
public class mbProducto implements java.io.Serializable{

    private Producto obj_Producto;
    private List<Producto> lstProductos;
    private List<Producto> lstProductosFiltrada;
    
    public mbProducto() {
        obj_Producto = new Producto();
    }

    public Producto getObj_Producto() {
        return obj_Producto;
    }

    public void setObj_Producto(Producto obj_Producto) {
        this.obj_Producto = obj_Producto;
    }
    
    public List<Producto> getLstProductosFiltrada() {
        return lstProductosFiltrada;
    }

    public void setLstProductosFiltrada(List<Producto> lstProductosFiltrada) {
        this.lstProductosFiltrada = lstProductosFiltrada;
    }
    
    public List<Producto> getLstProducto(){
        ProductoDAO obj_ProductoDao = new ProductoDAOImpl();
        lstProductos = obj_ProductoDao.consultarProducto();
        return lstProductos; 
    }
    
    public List<Producto> getLstProductoCategoria(int id_cat){
        ProductoDAO obj_ProductoDao = new ProductoDAOImpl();
        return obj_ProductoDao.consultarProductoCategoria(id_cat);
    }
    
    public List<Producto> getLstVideojuegos(){
        ProductoDAO obj_ProductoDao = new ProductoDAOImpl();
        return obj_ProductoDao.consultarVideojuegos();
    }
    
    public List<Producto> getLstAccesorios(){
        ProductoDAO obj_ProductoDao = new ProductoDAOImpl();
        return obj_ProductoDao.consultarAccesorios();
    }
    
    public List<Producto> getLstConsolas(){
        ProductoDAO obj_ProductoDao = new ProductoDAOImpl();
        return obj_ProductoDao.consultarConsolas();
    }
    
    public void agregarProducto(){
        ProductoDAO obj_ProductoDao = new ProductoDAOImpl();
        try{
            obj_ProductoDao.agregarProducto(obj_Producto);
            obj_Producto = new Producto();
            FacesContext.getCurrentInstance().addMessage(null,
                   new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","Los datos fueron insertados correctamente"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Msg",e.getMessage()));
        }
        
        obj_Producto = new Producto();
    }
    
    public void modificarProducto(){
        ProductoDAO obj_ProductoDao = new ProductoDAOImpl();
        try{
            obj_ProductoDao.modificarProducto(obj_Producto);
            obj_Producto = new Producto();
            FacesContext.getCurrentInstance().addMessage(null,
                   new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","Los datos fueron modificados correctamente"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Msg",e.getMessage()));
        }
        
        obj_Producto = new Producto();
    }
    
    public void eliminarProducto(){
        ProductoDAO obj_ProductoDao = new ProductoDAOImpl();
        try{
            obj_ProductoDao.eliminarProducto(obj_Producto);
            obj_Producto = new Producto();
            FacesContext.getCurrentInstance().addMessage(null,
                   new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","Los datos fueron eliminados correctamente"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Msg",e.getMessage()));
        }
        
        obj_Producto = new Producto();
    }
        
}
