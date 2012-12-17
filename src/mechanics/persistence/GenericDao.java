/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics.persistence;

import java.io.Serializable;
import java.util.List;
import mechanics.domain.Person;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author rodrigo
 */
public class GenericDao<T> implements Dao<T> {

    private Session session;
    private boolean closeSession = true;
    private Class objectClass;

    public GenericDao(Session session, boolean closeSession, Class objectClass) {
        this.session = session;
        this.closeSession = closeSession;
        this.objectClass = objectClass;

    }

    public void saveOrUpdate(T object) throws HibernateException {
        Transaction tx = session.beginTransaction();

        try {
            session.saveOrUpdate(object);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            throw e;
        } finally {
            if (closeSession) {
                session.close();
            }
        }
    }

    public boolean delete(T object) throws HibernateException {
        Transaction tx = session.beginTransaction();
        try {
            session.delete(object);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            throw e;
        } finally {
            if (closeSession) {
                session.close();
            }
        }
        return true;
    }

    public T find(Serializable id) throws HibernateException {
        T obj;
        Transaction tx = session.beginTransaction();
        try {
            obj = (T) session.load(objectClass, id);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            throw e;
        } finally {
            if (closeSession) {
                session.close();
            }
        }
        return obj;
    }

    public List<T> all() throws HibernateException {
        List<T> objects;
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("from " + objectClass.getName());
            objects = query.list();
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            throw e;
        } finally {
            if (closeSession) {
                session.close();
            }
        }
        
        return objects;
    }
}
