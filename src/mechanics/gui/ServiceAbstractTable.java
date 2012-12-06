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

    public Object getValueAt(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
