/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Orden;
import java.util.List;

/**
 *
 * @author keysw
 */

public interface OrdenDAO {
    public List<Orden> consultarOrden();
    public void agregarOrden(Orden orden);
    public void modificarOrden(Orden orden);
    public void eliminarOrden(Orden orden);
    public int nuevoID();
}
