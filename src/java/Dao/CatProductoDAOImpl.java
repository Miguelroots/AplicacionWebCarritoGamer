/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Persistencia.NewHibernateUtil;
import java.util.List;
import Modelo.CategoriaProducto;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author USER
 */
public class CatProductoDAOImpl implements CatProductoDao{

    @Override
    public List<CategoriaProducto> consultarCategoria() {
        Session session = null;
        List<CategoriaProducto> lstProducto = null;

        try{
           session = NewHibernateUtil.getSessionFactory().openSession();
           Query query = session.createQuery("FROM CategoriaProducto ORDER BY id_categoria_producto");
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
    public void agregarCategoria(CategoriaProducto obj_cat_pro) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(obj_cat_pro);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        finally{
            if(session != null){
                session.close();
            }        
        }
    }

    @Override
    public void modificarCategoria(CategoriaProducto obj_cat_pro) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(obj_cat_pro);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        finally{
            if(session != null){
                session.close();
            }        
        }
    }

    @Override
    public void eliminarCategoria(CategoriaProducto obj_cat_pro) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(obj_cat_pro);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        finally{
            if(session != null){
                session.close();
            }        
        }
    }
    
}
