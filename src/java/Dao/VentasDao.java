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
 * @author DELL
 */

//private int idOrden;
//     private int idUsuario;
//     private int idMetodoPago;
//     private int idEnvio;
//     private BigDecimal total;
public interface VentasDao {
    public List<Orden> consultarVentas();
//    public List<Orden> consultarVentasUsuario(int id_Usuario);
//    public List<Orden> consultarVentasMetodoPago(int id_MetodoPago);
//    public List<Orden> consultarVentasEnvio(int id_Envio);
    public void agregarVentas(Orden orden);
    public void modificarVentas(Orden orden);
    public void eliminarVentas(Orden orden);
}
