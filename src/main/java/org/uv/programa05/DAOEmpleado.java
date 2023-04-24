/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programa05;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author FHATIMA
 */
public class DAOEmpleado implements IDAOGeneral<Empleado, Long>{

    @Override
    public Empleado create(Empleado p) {
              Session session=HibernateUtil.getSession();
              Transaction t=session.beginTransaction();
              
              session.save(p);
              Logger.getLogger(DAOEmpleado.class.getName()).log(Level.INFO, "se guaardo empleado");
              
              
              t.commit();
              session.close();
              return p;
    }

    @Override
    public boolean delete(Long id) {
      Session session = HibernateUtil.getSession();
      Transaction t=session.beginTransaction();
      
      boolean res=false;
      
      Empleado empleado=findbyID(id);
      if (empleado==null)
          res=false;
      else{
          session.delete(empleado);
          res= true;
      }
        
       t.commit();
       session.close();
        return res;
    }

    @Override
    public Empleado update(Empleado p, Long id) {
        Session session=HibernateUtil.getSession();
        Transaction t=session.beginTransaction();
      
      Empleado empleado=findbyID(id);
      if (empleado!=null)
         session.update(empleado);
        
       t.commit();
       session.close();
        return empleado;
    }

    @Override
    public List<Empleado> findAll() {
       List<Empleado> lstRes=null;
       
        Session session = HibernateUtil.getSession();
        Transaction t=session.beginTransaction();
        lstRes = session.createQuery("from ejemplo").list();
       
        t.commit();
        session.close();
         return lstRes;
    }

    @Override
    public Empleado findbyID(Long id) {
        Empleado empleado=null;
        Session session=HibernateUtil.getSession();
        Transaction t=session.beginTransaction();
       
       empleado = session.get(Empleado.class, id);
       
        t.commit();
        session.close();
        return empleado;
    }


}