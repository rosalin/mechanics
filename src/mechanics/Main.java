/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mechanics;

import java.io.Serializable;
import java.security.Provider.Service;
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
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        Dao<Service> dao = new GenericDao<Service>(session, false, Service.class);
        List<Service> s = dao.all();
        System.out.println("TESTE = " + s.size());
    }
}
