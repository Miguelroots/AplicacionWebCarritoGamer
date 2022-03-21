/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Producto;
import Modelo.CategoriaProducto;
import java.util.List;

/**
 *
 * @author keysw
 */
public interface ProductoDAO {
    public List<Producto> consultarProducto();
    public List<Producto> consultarVideojuegos();
    public List<Producto> consultarAccesorios();
    public List<Producto> consultarConsolas();
    public List<Producto> consultarProductoCategoria(int id_categoria);
    public void agregarProducto(Producto producto);
    public void modificarProducto(Producto producto);
    public void eliminarProducto(Producto producto);
}
