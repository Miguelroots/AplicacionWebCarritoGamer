/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Producto;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author keysw
 */
public class ProductoDAOImpl implements ProductoDAO{

    @Override
    public List<Producto> consultarProducto() {
        Session session = null;
        List<Producto> lstProducto = null;

        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           Query query = session.createQuery("FROM Producto ORDER BY id_producto");
           lstProducto = query.list();    

        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(session != null){
                session.close();
            }

        } 
        return lstProducto;
    }
    
    @Override
    public List<Producto> consultarProductoCategoria(int id_categoria){
        Session session = null;
        List<Producto> lstProducto = null;

        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           Query query = session.createQuery("From Producto Where id_categoria_producto = "+id_categoria);
           lstProducto = query.list();    

        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(session != null){
                session.close();
            }

        } 
        return lstProducto;
    }
    @Override
    public List<Producto> consultarAccesorios(){
        Session session = null;
        List<Producto> lstProducto = null;

        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           Query query = session.createQuery("FROM Producto WHERE id_categoria_producto = 1 OR id_categoria_producto BETWEEN 4 AND 8 ORDER BY id_producto");
           lstProducto = query.list();    

        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(session != null){
                session.close();
            }

        } 
        return lstProducto;
    }
    
    @Override
    public List<Producto> consultarVideojuegos(){
        Session session = null;
        List<Producto> lstProducto = null;

        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           Query query = session.createQuery("FROM Producto WHERE id_categoria_producto = 2 ORDER BY id_producto");
           lstProducto = query.list();    

        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(session != null){
                session.close();
            }

        } 
        return lstProducto;
    }
    
    @Override
    public List<Producto> consultarConsolas(){
        Session session = null;
        List<Producto> lstProducto = null;

        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           Query query = session.createQuery("FROM Producto WHERE id_categoria_producto = 3 ORDER BY id_producto");
           lstProducto = query.list();    

        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(session != null){
                session.close();
            }

        } 
        return lstProducto;
    }

    @Override
    public void agregarProducto(Producto producto) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(producto);
            session.getTransaction().commit();
        } 
        catch (HibernateException e) {
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
    public void modificarProducto(Producto producto) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(producto);
            session.getTransaction().commit();
        } catch (HibernateException e) {
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
    public void eliminarProducto(Producto producto) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(producto);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }
        finally{
            if(session != null){
                session.close();
            }        
        }
    }
}
    

