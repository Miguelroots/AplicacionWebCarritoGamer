/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Usuario;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DELL
 */
public class UsuarioDAOImpl implements UsuarioDao {

    @Override
    public List<Usuario> consultarUsuario() {
       Session session = null;
       List<Usuario> lstUsuario = null;
       
       try{
          session = NewHibernateUtil.getSessionFactory().openSession();
          Query query = session.createQuery("FROM Usuario ORDER BY id_usuario");
          lstUsuario = query.list();    
       
       }
       catch(HibernateException e){
           System.out.println(e.getMessage());
       }
       finally{
           if(session != null){
               session.close();
           }
       
       } 
       return lstUsuario;
    }

    @Override
    public void agregarUsuario(Usuario obj_Usuario) {
        Session session = null;
        
        try{
          session = NewHibernateUtil.getSessionFactory().openSession();
          session.beginTransaction();
          session.save(obj_Usuario);
          session.getTransaction().commit();

        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }
        finally{
            if(session != null){
                session.close();
            }
        } 
        
    }

    @Override
    public void modificarUsuario(Usuario obj_Usuario) {
        Session session = null;
       
       
        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.update(obj_Usuario);
           session.getTransaction().commit();

        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }
        finally{
            if(session != null){
                session.close();
            }

        } 
    }

    @Override
    public void eliminarUsuario(Usuario obj_Usuario) {
        Session session = null;
       
       
        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.delete(obj_Usuario);
           session.getTransaction().commit();

        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }
        finally{
            if(session != null){
                session.close();
            }

        } 
    }
    
    @Override
    public int nuevoID(){
        Session session = null;
        List<Integer> lstCodUsuario = null;
       
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("SELECT MAX(id_usuario)+1 FROM Usuario");
            lstCodUsuario = query.list();    
            
            if(!lstCodUsuario.isEmpty()){
                return lstCodUsuario.get(0);
            }
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(session != null){
               session.close();
            }
       
        } 
        
        
        return 0;
    }

    @Override
    public Usuario iniciarSesion(Usuario usuario) {
        Session session = null;
        List<Usuario> lstUsuario = null;
       
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM Usuario WHERE nickname = '"+usuario.getNickname()
                    +"' AND contrasena = '"+usuario.getContrasena()+"'");
            lstUsuario = query.list();
            
            if(!lstUsuario.isEmpty()){
                return lstUsuario.get(0);
            }
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(session != null){
               session.close();
            }
        } 
        
        return null;
    }
    
}
