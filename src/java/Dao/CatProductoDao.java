/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;
import Modelo.CategoriaProducto;

/**
 *
 * @author USER
 */
public interface CatProductoDao {
    public List<CategoriaProducto> consultarCategoria();
    public void agregarCategoria(CategoriaProducto obj_cat_pro);
    public void modificarCategoria(CategoriaProducto obj_cat_pro);
    public void eliminarCategoria(CategoriaProducto obj_cat_pro);
    
}
