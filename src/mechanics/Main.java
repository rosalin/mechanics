/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mechanics;

import java.util.ArrayList;
import java.util.List;
import mechanics.domain.Person;
import mechanics.domain.Vehicle;
import mechanics.persistence.Dao;
import mechanics.persistence.GenericDao;
import mechanics.persistence.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author rodrigo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        Query q = session.createQuery("from Person");
       
        ArrayList<Person> a = (ArrayList<Person>) q.list();
        int i=0;

        while(i < a.size()){
            System.out.println(a.get(i).getName());
            i++;
        }


        System.out.println("TESTES");

        Vehicle v = new Vehicle("dasd","123","Chevrolet","Corsa", "2000", "123");
        mechanics.domain.Service s = new mechanics.domain.Service();
        s.setDescription("TESTE");
        v.getServices().add(s);
        s.setVehicle(v);
 
        //get all vehicles
        System.out.print("---------------------------------TESTE FIND ALL -----------------------------------------");
        Dao d2 = new GenericDao(session, false, v.getClass());
        d2.saveOrUpdate(v);

        List<Vehicle> list = d2.all();
        for (i=0; i<list.size(); i++){
            System.out.println("#####################" + i +"#####################");
            System.out.println(list.get(i).getModel());
            System.out.println(list.get(i).getId());
            System.out.println("##################################################");
        }
        System.out.println("--------------------------------END FIND ALL -------------------------------------------");




        System.out.println("---------------------------------TESTE FIND BY ID-----------------------------------------");
        Vehicle vehicle = (Vehicle) d2.find(Long.valueOf(1));
        System.out.println(vehicle.getModel());
        System.out.println(vehicle.getColor());
        System.out.println(vehicle.getId());
        System.out.println("---------------------------------END FIND BY ID-----------------------------------------");


        System.out.println("---------------------------------TESTE DELETE BY ID-----------------------------------------");
        if (d2.delete(vehicle))
           System.out.println("removido com sucesso!");
        System.out.println("---------------------------------END DELETE BY ID-----------------------------------------");
    }

}
