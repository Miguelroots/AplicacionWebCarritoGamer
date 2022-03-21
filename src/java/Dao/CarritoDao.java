/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Carrito;
import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface CarritoDao {
    public List<Carrito> consultarCarrito();
    public List<Carrito> consultarCarritoUsuario(int id_usuario);
    public void agregarCarrito(Carrito obj_Carrito);
    public void eliminarCarrito(Carrito obj_Carrito);
    public int nuevoID();
}
