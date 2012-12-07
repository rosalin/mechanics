/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mechanics.gui;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import mechanics.domain.Service;

/**
 *
 * @author rodrigo
 */
public class ServiceAbstractTable extends AbstractTableModel {

    private ArrayList<Service> services =  new ArrayList<Service>();
    private String[] columns = {"Data da execução","Descrição", "Km", "Proprietário" };

    public int getRowCount() {
        return services.size();
    }

    public int getColumnCount() {
        return columns.length;
    }

    public void add(Service service){
        services.add(service);
        fireTableDataChanged();
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    

    

    public Object getValueAt(int rowIndex, int columnIndex) {
        Service service = (Service) services.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return service.getCreatedAt();
            case 1:
                return service.getDescription();
            case 2:
                return service.getKm();
            case 3:
                return service.getOwner().getName();
            default:
                return null;
        }

    }


    @Override
     public String getColumnName(int column) {
        return columns[column];
     }

   @Override
     public Class getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

   
}
