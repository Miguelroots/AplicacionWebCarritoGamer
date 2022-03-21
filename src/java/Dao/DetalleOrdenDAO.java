/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.DetalleOrden;
import java.util.List;

/**
 *
 * @author keysw
 */
public interface DetalleOrdenDAO {
    public List<DetalleOrden> consultarDetalleOrden();
    public void agregarDetalleOrden(DetalleOrden detalle);
    public void modificarDetalleOrden(DetalleOrden detalle);
    public void eliminarDetalleOrden(DetalleOrden detalle);
    public int nuevoID();
}
