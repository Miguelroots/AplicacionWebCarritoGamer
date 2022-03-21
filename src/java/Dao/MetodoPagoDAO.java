/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.MetodoPago;
import java.util.List;

/**
 *
 * @author keysw
 */
public interface MetodoPagoDAO {
    public List<MetodoPago> consultarMetodoPago();
    public void agregarMetodoPago(MetodoPago metPago);
    public void modificarMetodoPago(MetodoPago metPago);
    public void eliminarMetodoPago(MetodoPago metPago);
}
