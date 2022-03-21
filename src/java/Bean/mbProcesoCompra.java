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
import Dao.EnvioDAO;
import Dao.EnvioDAOImpl;
import Dao.OrdenDAO;
import Dao.OrdenDAOImpl;
import Modelo.Carrito;
import Modelo.DetalleOrden;
import Modelo.Envio;
import Modelo.MetodoPago;
import Modelo.Orden;
import Modelo.Producto;
import Modelo.Usuario;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author keysw
 */
@Named(value = "mbProcesoCompra")
@ViewScoped
public class mbProcesoCompra implements Serializable{

    //OTROS DATOS
    private String direccion;
    private String ciudad;
    private String provincia;
    private String codigoPostal;
    private int telefono;
    
    //OBJETOS
    private Usuario usuario;
    private MetodoPago metodoPago;
    private Envio envio;
    private Orden orden;
    private DetalleOrden detalleOrden;
    private Producto producto;
    private Carrito carrito;
    
    public mbProcesoCompra() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (Usuario) context.getExternalContext().getSessionMap().get("login");
        carrito = new Carrito();
        Envio envio = new Envio();
        Orden orden = new Orden();
        DetalleOrden detalleOrden = new DetalleOrden();
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Envio getEnvio() {
        return envio;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }
    
    public List<String> getLstCiudades(){
        String paisUsuario = usuario.getPais();
        List<String> lstCiudadEcuador = new ArrayList<>();
        lstCiudadEcuador.add("Guayaquil");
        lstCiudadEcuador.add("Quito");
        
        List<String> lstCiudadColombia = new ArrayList<>();
        lstCiudadColombia.add("Barranquilla");
        lstCiudadColombia.add("Cali");
        
        List<String> lstCiudadBrasil = new ArrayList<>();
        lstCiudadBrasil.add("Recife");
        lstCiudadBrasil.add("Manaos");
        
        if(paisUsuario.equals("Ecuador") ){
            return lstCiudadEcuador;
        }else if(paisUsuario.equals("Colombia")){
            return lstCiudadColombia;
        }else if(paisUsuario.equals("Brasil")){
            return lstCiudadBrasil;
        }
        
        return null;
    }
    
    //FUNCIONES
    public void realizarPedido(){
        CarritoDao obj_CarritoDAO = new CarritoDAOImpl();
        DetalleOrdenDAO obj_DetalleOrdenDAO = new DetalleOrdenDAOImpl();
        OrdenDAO obj_OrdenDAO = new OrdenDAOImpl();
        EnvioDAO obj_EnvioDAO = new EnvioDAOImpl();
        
        try {
            int index = 0;
            List<Carrito> lstArticulosCarro = obj_CarritoDAO.consultarCarritoUsuario(usuario.getIdUsuario());
            while(lstArticulosCarro.size() > index){
                lstArticulosCarro = obj_CarritoDAO.consultarCarritoUsuario(usuario.getIdUsuario());
                carrito = lstArticulosCarro.get(0);
                
                producto = carrito.getProducto();
                BigDecimal cant = BigDecimal.valueOf(carrito.getCantidad());
                BigDecimal precioCalculado = cant.multiply(producto.getPrecio());
                
                envio.setIdEnvio(obj_EnvioDAO.nuevoID());
                envio.setUsuario(usuario);
                envio.setPais(usuario.getPais());
                envio.setNombre(usuario.getNombre());
                envio.setDireccion(direccion);
                envio.setCiudad(ciudad);
                envio.setProvincia(provincia);
                envio.setCodigoPostal(codigoPostal);
                envio.setTelefono(telefono);
                obj_EnvioDAO.agregarEnvio(envio);
                
                orden.setIdOrden(obj_OrdenDAO.nuevoID());
                orden.setEnvio(envio);
                orden.setMetodoPago(metodoPago);
                orden.setUsuario(usuario);
                orden.setTotal(precioCalculado);
                obj_OrdenDAO.agregarOrden(orden);
                
                detalleOrden = new DetalleOrden();
                detalleOrden.setIdDetalleOrden(obj_DetalleOrdenDAO.nuevoID());
                detalleOrden.setOrden(orden);
                detalleOrden.setProducto(producto);
                detalleOrden.setCantidad(carrito.getCantidad());
                detalleOrden.setPrecio(precioCalculado);
                obj_DetalleOrdenDAO.agregarDetalleOrden(detalleOrden);
                
                obj_CarritoDAO.eliminarCarrito(carrito);
            }
        }catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Msg",e.getMessage()));
        }   
        
    }
}
