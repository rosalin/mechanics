/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package relatorio;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Vector;
import mechanics.domain.Service;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import org.hibernate.engine.jdbc.internal.Formatter;

/**
 *
 * @author rodrigo
 */
public class ServiceJRDataSource implements JRDataSource{

   private Iterator<Service> iterator;
   private Service cursor;

    public ServiceJRDataSource(Vector<Service> services) {
        super();
        iterator = services.iterator();
    }


    public boolean next() throws JRException {
        boolean retorno = iterator.hasNext();
        if (retorno){
            cursor = iterator.next();
        }
        return retorno;
    }

    public Object getFieldValue(JRField nome) throws JRException {
        Service service = cursor;
        if (nome.getName().equals("DESCRIPTION")){
            return service.getDescription();
        }
        if (nome.getName().equals("KM")){
            return service.getKm();
        }
        if (nome.getName().equals("CREATEDAT")){
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            return formatter.format(service.getCreatedAt());
        }
        if (nome.getName().equals("OWNER")){
            return service.getOwner().getName();
        }
        return null;
    }
}
