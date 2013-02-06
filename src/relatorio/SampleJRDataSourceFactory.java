/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package relatorio;

import groovy.util.Factory;
import java.util.Date;
import java.util.Vector;
import mechanics.domain.Person;
import mechanics.domain.Service;
import net.sf.jasperreports.engine.JRDataSource;

/**
 *
 * @author rodrigo
 */
public class SampleJRDataSourceFactory{
    private static  JRDataSource data;

    public static JRDataSource createDataSource(Service s){
        if (data == null){
            Vector<Service> service = new Vector<Service>();
            service.add(s);
            data = new ServiceJRDataSource(service);
        }
        return data;
    }
}
