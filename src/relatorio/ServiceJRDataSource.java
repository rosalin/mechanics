/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package relatorio;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Vector;
import java.util.jar.Attributes.Name;
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

        if (nome.getName().equals("ID")){
            return service.getId();
        }
        if (nome.getName().equals("DESCRIPTION")){
            return service.getDescription();
        }
        if (nome.getName().equals("KM")){
            return service.getKm();
        }
        if (nome.getName().equals("PRICE")){
            return service.getPrice();
        }
        if (nome.getName().equals("CREATEDAT")){
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            return formatter.format(service.getCreatedAt());
        }
        if (nome.getName().equals("OWNER")){
            return service.getOwner().getName();
        }
        if (nome.getName().equals("PLACA")){
            return service.getVehicle().getPlaque();
        }
        if (nome.getName().equals("MARCA")){
            return service.getVehicle().getBrand();
        }
        if (nome.getName().equals("MODELO")){
            return service.getVehicle().getModel();
        }
        if (nome.getName().equals("COR")){
            return service.getVehicle().getColor();
        }
        if (nome.getName().equals("ANO")){
            return service.getVehicle().getYear();
        }

        return null;
    }
}
