/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface UsuarioDao {
    public List<Usuario> consultarUsuario();
    public void agregarUsuario(Usuario usuario);
    public void modificarUsuario(Usuario usuario);
    public void eliminarUsuario(Usuario usuario);
    public Usuario iniciarSesion(Usuario usuario);
    public int nuevoID();
}
