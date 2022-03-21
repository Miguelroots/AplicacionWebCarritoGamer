/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.MetodoPago;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author keysw
 */
public class MetodoPagoDAOImpl implements MetodoPagoDAO{

    @Override
    public List<MetodoPago> consultarMetodoPago() {
        Session session = null;
        List<MetodoPago> lstMetodoPago = null;

        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           Query query = session.createQuery("FROM MetodoPago ORDER BY idMetodoPago");
           lstMetodoPago = query.list();    

        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(session != null){
                session.close();
            }

        } 
        return lstMetodoPago;
    }

    @Override
    public void agregarMetodoPago(MetodoPago metPago) {
        Session session = null;
       
       
        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.save(metPago);
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
    public void modificarMetodoPago(MetodoPago metPago) {
        Session session = null;
       
       
        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.update(metPago);
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
    public void eliminarMetodoPago(MetodoPago metPago) {
        Session session = null;
       
       
        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.delete(metPago);
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
    
}
