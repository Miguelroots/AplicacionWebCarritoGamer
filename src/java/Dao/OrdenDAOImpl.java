/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Orden;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author keysw
 */
public class OrdenDAOImpl implements OrdenDAO{

    @Override
    public List<Orden> consultarOrden() {
        Session session = null;
        List<Orden> lstOrden = null;

        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           Query query = session.createQuery("FROM Orden ORDER BY id_orden");
           lstOrden = query.list();    

        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(session != null){
                session.close();
            }

        } 
        return lstOrden;
    }

    @Override
    public void agregarOrden(Orden orden) {
        Session session = null;

        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.save(orden);
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
    public void modificarOrden(Orden orden) {
        Session session = null;

        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.update(orden);
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
    public void eliminarOrden(Orden orden) {
        Session session = null;

        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.delete(orden);
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
            Query query = session.createQuery("SELECT MAX(idOrden)+1 FROM Orden");
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
