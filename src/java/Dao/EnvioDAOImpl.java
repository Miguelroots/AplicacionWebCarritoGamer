/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Envio;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author keysw
 */
public class EnvioDAOImpl implements EnvioDAO{

    @Override
    public List<Envio> consultarEnvio() {
        Session session = null;
        List<Envio> lstEnvio = null;

        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           Query query = session.createQuery("FROM Envio ORDER BY id_envio");
           lstEnvio = query.list();    

        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(session != null){
                session.close();
            }

        } 
        return lstEnvio;
    }

    @Override
    public void agregarEnvio(Envio envio) {
        Session session = null;
        
        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.save(envio);
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
    public void modificarEnvio(Envio envio) {
        Session session = null;
        
        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.update(envio);
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
    public void eliminarEnvio(Envio envio) {
        Session session = null;
        
        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.delete(envio);
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
            Query query = session.createQuery("SELECT MAX(idEnvio)+1 FROM Envio");
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
