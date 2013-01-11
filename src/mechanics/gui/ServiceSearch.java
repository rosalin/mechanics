/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ServiceSearch.java
 *
 * Created on 04/12/2012, 18:45:04
 */
package mechanics.gui;

import com.mchange.v2.log.log4j.Log4jMLog;
import java.awt.JobAttributes;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import mechanics.domain.Person;
import mechanics.domain.Service;
import mechanics.domain.Vehicle;
import mechanics.persistence.HibernateUtil;
import mechanics.persistence.specialist.VehicleDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author rodrigo
 */
public class ServiceSearch extends javax.swing.JDialog {

    /** Creates new form ServiceSearch */
    public ServiceSearch(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        ListSelectionModel cellSelectionModel = jTableResult.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        addlListenerToJTable(cellSelectionModel);


        //adding double click listner
        jTableResult.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    if (selectService != null) {
                        ServiceEditUi serviceEdit = new ServiceEditUi(null, true, selectService);
                        serviceEdit.setVisible(true);
                        //JOptionPane.showMessageDialog(null, "TESTE");
                    }
                }
            }
        });



    }

    private void addlListenerToJTable(ListSelectionModel cellSelectionModel) {
        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                String selectedData = null;

                int[] selectedRow = jTableResult.getSelectedRows();
                //int[] selectedColumns = jTableResult.getSelectedColumns();

                // for (int i = 0; i < selectedRow.length; i++) {
                //     for (int j = 0; j < selectedColumns.length; j++) {
                //         selectedData = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
                //     }
                //}
                if (selectedRow.length > 0) {
                    selectService = abstractTable.getServices().get(selectedRow[0]);
                    owner = abstractTable.getServices().get(selectedRow[0]).getOwner();
                    System.out.println("Selected service: " + selectService);
                    System.out.println("Selected owner: " + owner);
                }

            }
        });

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextFieldPlaque = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResult = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar serviços por placa"));

        jLabel1.setText("Placa");

        jButtonSearch.setBackground(new java.awt.Color(204, 204, 204));
        jButtonSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mechanics/gui/icons/icon pesquisar.png"))); // NOI18N
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(321, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(jTextFieldPlaque, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSearch)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPlaque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonSearch)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTableResult.setModel(abstractTable);
        jScrollPane1.setViewportView(jTableResult);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        /*Service service = new Service();
        service.setCreatedAt(new Date());
        service.setDescription("este");
        service.setKm(181981);
        Person p = new Person();
        p.setName("Rodrigo");
        service.setOwner(p);

        abstractTable.add(service);*/

        abstractTable.clear();
        Session session = HibernateUtil.getSessionFactory().openSession();
        HibernateUtil.setCurrentSession(session); 

        try {
            String plaque = jTextFieldPlaque.getText();
            VehicleDao dao = new VehicleDao(session, false);
            Vehicle v = dao.getVehiclePerPlaque(plaque);

            if(v == null){
                JOptionPane.showMessageDialog(this, "Veículo não encontrado!");
                return;
            }


            int i;
            List<Service> services = v.getServices();
            if (services.size() <= 0) {
                JOptionPane.showMessageDialog(null, "Não há serviços cadastrados para este veículo!!!");
            } else {
                for (i = 0; i < services.size(); i++) {
                    services.get(i).setVehicle(v);
                    System.out.println(services.get(i).getOwner().getName());
                    abstractTable.add(services.get(i));
                }
            }

        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(this, "Um erro inesperado aconteceu: " + e.getMessage());
            Log4jMLog.info(e.getMessage());
        } 






    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Session session = HibernateUtil.getCurrentSession();
        if(session.isOpen()){
            session.close();
            System.out.println("Session closed");
        }


    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                ServiceSearch dialog = new ServiceSearch(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }*/

    
    private Service selectService = null;
    private Person owner = null;
    private ServiceAbstractTable abstractTable = new ServiceAbstractTable();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableResult;
    private javax.swing.JTextField jTextFieldPlaque;
    // End of variables declaration//GEN-END:variables
}
