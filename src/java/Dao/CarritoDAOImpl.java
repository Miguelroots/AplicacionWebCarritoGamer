/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Carrito;
import Modelo.Orden;
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
public class CarritoDAOImpl implements CarritoDao{

    @Override
    public List<Carrito> consultarCarrito() {
        Session session = null;
        List<Carrito> lstCarrito = null;

        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           Query query = session.createQuery("FROM Carrito ORDER BY id_Carrito");
           lstCarrito = query.list();    

        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(session != null){
                session.close();
            }

        } 
        return lstCarrito;
    }

    @Override
    public void agregarCarrito(Carrito obj_Carrito) {
        Session session = null;
       
        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.save(obj_Carrito);
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
    public void eliminarCarrito(Carrito obj_Carrito) {
        Session session = null;
       
        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.delete(obj_Carrito);
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
    public List<Carrito> consultarCarritoUsuario(int id_usuario) {
        Session session = null;
        List<Carrito> lstCarrito = null;
        
        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           Query query = session.createQuery("FROM Carrito WHERE id_usuario = "+id_usuario+" ORDER BY id_Carrito");
           lstCarrito = query.list();
        }catch(HibernateException e){
            System.out.println(e.getMessage());
        }
        
        return lstCarrito;
    }

    @Override
    public int nuevoID() {
        Session session = null;
        List<Integer> lstCodCarro = null;
       
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("SELECT MAX(idCarrito)+1 FROM Carrito");
            lstCodCarro = query.list();    
            
            if(!lstCodCarro.isEmpty()){
                return lstCodCarro.get(0);
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
    
}
