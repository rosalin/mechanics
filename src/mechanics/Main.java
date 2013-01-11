/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mechanics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import mechanics.domain.Person;
import mechanics.domain.Vehicle;
import mechanics.persistence.Dao;
import mechanics.persistence.GenericDao;
import mechanics.persistence.HibernateUtil;
import org.hibernate.HibernateException;
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
    /*public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        Dao<Vehicle> dao = new GenericDao<Vehicle>(session, false, Vehicle.class);
        Vehicle v = dao.find(new Long(11));



        System.out.println(v.getId());
        System.out.println(v.getServices().get(0).getOwner());
    }*/
}
