/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package org.uv.programa05;
import org.hibernate.Session;
/**
 *
 * @author FHATIMA
 */
public class Programa05 {

    public static void main(String[] args) {
//        Session session= HibernateUtil.getSession();
        
//        System.out.println("Hello World!");
        
        DAOEmpleado dao = new DAOEmpleado();
        Empleado empleado = new Empleado();
        
//        empleado.setClave(11);
//        empleado.setNombre("fha");
//        empleado.setDireccion("av1");
//        empleado.setTelefono("2345");
//        
//             dao.create(empleado);
        
        Empleado emp=dao.findbyID(11L);
        if (emp!=null){
            System.out.println(emp.getClave());
        }else{
            System.out.println("No funciona");
        }
       
        
    }
}
