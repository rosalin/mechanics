/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mechanics.persistence;

import java.awt.Event;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author rodrigo
 */
public interface Dao<T> {
    public void saveOrUpdate(T object) throws HibernateException;
    public boolean delete(T object);
    public T find(Serializable id);
    public List<T> all() throws HibernateException;
}
