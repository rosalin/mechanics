/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics.persistence.specialist;

import java.util.List;
import mechanics.domain.Person;
import mechanics.domain.Vehicle;
import mechanics.persistence.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author rodrigo
 */
public class VehicleDao {

    private boolean closeSession = true;
    private Session session;

    public VehicleDao(Session session, boolean closeSession) {
        this.session = session;
        this.closeSession = closeSession;
    }

    public Vehicle getVehiclePerPlaque(String plaque) {
        try {
            String hql = ("from Vehicle as v where v.plaque = " + "\'" + plaque + "\'");
            Query q = session.createQuery(hql);
            List list = q.list();

            if (list.size()>0) {
                Vehicle v = (Vehicle) list.get(0);
                if (v != null) {
                    return v;
                }
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (this.closeSession) {
                session.close();
            }
        }

        return null;

    }
}
