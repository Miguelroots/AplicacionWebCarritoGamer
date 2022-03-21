/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.DetalleOrden;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author keysw
 */
public class DetalleOrdenDAOImpl implements DetalleOrdenDAO{

    @Override
    public List<DetalleOrden> consultarDetalleOrden() {
        Session session = null;
        List<DetalleOrden> lstDetalleOrden = null;

        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           Query query = session.createQuery("From DetalleOrden Order By id_detalle_orden");
           lstDetalleOrden = query.list();    

        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(session != null){
                session.close();
            }

        } 
        return lstDetalleOrden;
    }

    @Override
    public void agregarDetalleOrden(DetalleOrden detalle) {
        Session session = null;

        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.save(detalle);
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
    public void modificarDetalleOrden(DetalleOrden detalle) {
        Session session = null;

        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.update(detalle);
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
    public void eliminarDetalleOrden(DetalleOrden detalle) {
        Session session = null;

        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.delete(detalle);
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
    public int nuevoID() {
        Session session = null;
        List<Integer> lstCodCarro = null;
       
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("SELECT MAX(idDetalleOrden)+1 FROM DetalleOrden");
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
