/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Envio;
import java.util.List;

/**
 *
 * @author keysw
 */
public interface EnvioDAO {
    public List<Envio> consultarEnvio();
    public void agregarEnvio(Envio envio);
    public void modificarEnvio(Envio envio);
    public void eliminarEnvio(Envio envio);
    public int nuevoID();
}
