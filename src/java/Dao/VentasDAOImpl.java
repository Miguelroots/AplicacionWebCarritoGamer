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
 * @author DELL
 */
public class VentasDAOImpl implements VentasDao{

    @Override
    public List<Orden> consultarVentas() {
       Session session = null;
        List<Orden> lstVentas = null;

        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           Query query = session.createQuery("FROM Orden ORDER BY id_orden");
           lstVentas = query.list();    

        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(session != null){
                session.close();
            }

        } 
        return lstVentas;
    }

//    @Override
//    public List<Orden> consultarVentasUsuario(int id_Usuario) {
//        Session session = null;
//        List<Orden> lstVentas = null;
//
//        try{
//           session = NewHibernateUtil.getSessionFactory().openSession();
//           Query query = session.createQuery("From Orden Where id_Usuario = "+id_Usuario);
//           lstVentas = query.list();    
//
//        }
//        catch(HibernateException e){
//            System.out.println(e.getMessage());
//        }
//        finally{
//            if(session != null){
//                session.close();
//            }
//
//        } 
//        return lstVentas;
//    }
//
//    @Override
//    public List<Orden> consultarVentasMetodoPago(int id_MetodoPago) {
//               Session session = null;
//        List<Orden> lstVentas = null;
//
//        try{
//           session = NewHibernateUtil.getSessionFactory().openSession();
//           Query query = session.createQuery("From Orden Where id_MetodoPago"+id_MetodoPago);
//           lstVentas = query.list();    
//
//        }
//        catch(HibernateException e){
//            System.out.println(e.getMessage());
//        }
//        finally{
//            if(session != null){
//                session.close();
//            }
//
//        } 
//        return lstVentas;
//    }
//
//    @Override
//    public List<Orden> consultarVentasEnvio(int id_Envio) {
//               Session session = null;
//        List<Orden> lstVentas = null;
//
//        try{
//           session = NewHibernateUtil.getSessionFactory().openSession();
//           Query query = session.createQuery("From Orden Where id_Envio"+id_Envio);
//           lstVentas = query.list();    
//
//        }
//        catch(HibernateException e){
//            System.out.println(e.getMessage());
//        }
//        finally{
//            if(session != null){
//                session.close();
//            }
//
//        } 
//        return lstVentas;
//    }

    @Override
    public void agregarVentas(Orden obj_orden) {
        Session session = null;
        
        try{
          session = NewHibernateUtil.getSessionFactory().openSession();
          session.beginTransaction();
          session.save(obj_orden);
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
    public void modificarVentas(Orden obj_orden) {
       Session session = null;
       
       
        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.update(obj_orden);
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
    public void eliminarVentas(Orden obj_orden) {
        Session session = null;
       
       
        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.delete(obj_orden);
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
