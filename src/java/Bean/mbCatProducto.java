/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.CatProductoDAOImpl;
import Dao.CatProductoDao;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import Modelo.CategoriaProducto;

/**
 *
 * @author USER
 */
@Named(value = "mbCatProducto")
@ViewScoped
public class mbCatProducto implements java.io.Serializable{

    private CategoriaProducto obj_cat_producto;
    
    public mbCatProducto() {
    }

    public CategoriaProducto getObj_cat_producto() {
        return obj_cat_producto;
    }

    public void setObj_cat_producto(CategoriaProducto obj_cat_producto) {
        this.obj_cat_producto = obj_cat_producto;
    }
    
    public List<CategoriaProducto> getLstCategoriaProductos(){
        CatProductoDao catProductoDao = new CatProductoDAOImpl();
        return catProductoDao.consultarCategoria();
    }
    
    public void agregarCatProducto(){
        CatProductoDao catProductoDao = new CatProductoDAOImpl();
        catProductoDao.agregarCategoria(obj_cat_producto);
        obj_cat_producto = new CategoriaProducto();
     }

    public void modificarCatProducto(){
        CatProductoDao catProductoDao = new CatProductoDAOImpl();
        catProductoDao.modificarCategoria(obj_cat_producto);
        obj_cat_producto = new CategoriaProducto();
     }

      public void eliminarCatProducto(){
        CatProductoDao catProductoDao = new CatProductoDAOImpl();
        catProductoDao.eliminarCategoria(obj_cat_producto);
        obj_cat_producto = new CategoriaProducto();
     }
    
}
