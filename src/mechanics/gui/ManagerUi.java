/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ManagerUi.java
 *
 * Created on 19/11/2012, 10:14:35
 */
package mechanics.gui;

import com.mchange.v2.log.log4j.Log4jMLog;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import mechanics.domain.Person;
import mechanics.domain.Service;
import mechanics.domain.Vehicle;
import mechanics.persistence.Dao;
import mechanics.persistence.GenericDao;
import mechanics.persistence.HibernateUtil;
import mechanics.persistence.specialist.VehicleDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author rodrigo
 */
public class ManagerUi extends javax.swing.JFrame {

    /** Creates new form ManagerUi */
    public ManagerUi() {
        initComponents();


        Date date = new Date();
        jFormattedTextFieldDate.setText(formatter.format(date));

        jButtonUpdateClients.setEnabled(false);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldBrand = new javax.swing.JTextField();
        jTextFieldModel = new javax.swing.JTextField();
        jLabelOwner = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldPlaque = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jLabelStatus = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldKm = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxPersons = new javax.swing.JComboBox();
        jButtonUpdateClients = new javax.swing.JButton();
        jButtonaAddService = new javax.swing.JButton();
        try{
            MaskFormatter mf = new MaskFormatter("##/##/####");
            jFormattedTextFieldDate = new javax.swing.JFormattedTextField(mf);
            jLabel7 = new javax.swing.JLabel();
            jMenuBar1 = new javax.swing.JMenuBar();
            jMenu1 = new javax.swing.JMenu();
            jMenuItem2 = new javax.swing.JMenuItem();
            jMenuItem1 = new javax.swing.JMenuItem();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setTitle("ServControl");

            jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

            jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar Veículo"));

            jLabel3.setText("Proprietário:");

            jLabel2.setText("Modelo");

            jLabel1.setText("Marca");

            jTextFieldBrand.setEditable(false);

            jTextFieldModel.setEditable(false);

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldBrand)
                                .addComponent(jTextFieldModel, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(268, Short.MAX_VALUE))
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(15, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextFieldBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(11, 11, 11)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTextFieldModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabelOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(16, 16, 16))
            );

            jLabel4.setText("Placa");

            jButtonSearch.setBackground(new java.awt.Color(204, 204, 204));
            jButtonSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mechanics/gui/icons/icon pesquisar.png"))); // NOI18N
            jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonSearchActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel4)
                    .addGap(3, 3, 3)
                    .addComponent(jTextFieldPlaque, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButtonSearch)
                    .addGap(18, 18, 18)
                    .addComponent(jLabelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(420, Short.MAX_VALUE))
            );
            jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap(32, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jTextFieldPlaque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap())
                        .addComponent(jButtonSearch, javax.swing.GroupLayout.Alignment.TRAILING)))
            );

            jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Adcionar Serviço"));

            jTextAreaDescription.setColumns(20);
            jTextAreaDescription.setRows(5);
            jScrollPane1.setViewportView(jTextAreaDescription);

            jLabel5.setText("Serviços Realizados");

            jLabel6.setText("Data");

            jLabel9.setText("Km Atual:");

            jLabel10.setText("Proprietário Atual:");

            jComboBoxPersons.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o proprietário atual" }));

            jButtonUpdateClients.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mechanics/gui/icons/update-icon.png")));
            jButtonUpdateClients.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonUpdateClientsActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
            jPanel5.setLayout(jPanel5Layout);
            jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addComponent(jLabel9)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTextFieldKm, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel10)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jComboBoxPersons, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButtonUpdateClients, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE))
            );
            jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jTextFieldKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jComboBoxPersons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonUpdateClients, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(19, Short.MAX_VALUE))
            );

            jButtonaAddService.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mechanics/gui/icons/add.png"))); // NOI18N
            jButtonaAddService.setText("Adicionar Serviço");
            jButtonaAddService.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonaAddServiceActionPerformed(evt);
                }
            });

        }catch(ParseException e){
            Log4jMLog.info(e.getMessage());
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonaAddService))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(244, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jFormattedTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jButtonaAddService, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("Arquivo");

        jMenuItem2.setText("Veiculos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setText("Serviços");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        //VehicleController vehicleController = new VehicleController();
        //vehicleController.setUi(this);
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String plaque = jTextFieldPlaque.getText();
            
            VehicleDao dao = new VehicleDao(session, false);

            boolean status = Vehicle.isExists(plaque);
            if (status) {
                jLabelStatus.setText("Veículo Encontrado");

                Dao<Person> genericDao = new GenericDao<Person>(session, false, Person.class);
                List<Person> list = genericDao.all();
                list = Person.patchList(list);
                Vector vector = new Vector(list);

                jComboBoxPersons.setModel(new javax.swing.DefaultComboBoxModel(vector));
               

                vehicle = dao.getVehiclePerPlaque(plaque);
                jTextFieldBrand.setText(vehicle.getBrand());
                jTextFieldModel.setText(vehicle.getModel());
                Person owner = vehicle.getCurrentOwner();


                if (owner != null) {
                    jLabelOwner.setText(owner.getName());
                    jComboBoxPersons.setSelectedItem(owner);
                } else {
                    jLabelOwner.setText("Sem Registro");
                }

                jTextFieldKm.requestFocus();
                jTextFieldKm.setBackground(new Color(255, 177, 181));
                jButtonUpdateClients.setEnabled(true);


                //JOptionPane.showMessageDialog(this, "Veículo com a placa " + plaque + " já está cadastrado");
            } else {
                JOptionPane.showMessageDialog(this, "Veículo nao encontrado");
            }

        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(this, "Ocoreu um erro inesperado! " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }finally{
            if(session.isOpen())
                session.close();
        }

    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ServiceSearch serviceSearch = new ServiceSearch(this, false);
        serviceSearch.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButtonaAddServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonaAddServiceActionPerformed
        if (vehicle == null) {
            JOptionPane.showMessageDialog(this, "Pesquise por uma placa para adicionar o serviço");
            return;
        }

        String km = jTextFieldKm.getText();
        String text = jTextAreaDescription.getText();

        Date date = null;
        try {
            date = formatter.parse(jFormattedTextFieldDate.getText());
        } catch (ParseException ex) {
            Logger.getLogger(ManagerUi.class.getName()).log(Level.SEVERE, null, ex);
        }

        Service service = new Service();
        service.setKm(Long.valueOf(km));
        service.setDescription(text);
        service.setVehicle(vehicle);
        service.setCreatedAt(date);


        Person person = (Person) jComboBoxPersons.getSelectedItem();
        service.setOwner(person);
        vehicle.getServices().add(service);


        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Dao<Vehicle> dao = new GenericDao<Vehicle>(session, true, Vehicle.class);
            dao.saveOrUpdate(vehicle);

            jTextFieldKm.setBackground(new Color(242, 241, 240));
            jTextFieldKm.setText("");
            jTextAreaDescription.setText("");
            jTextFieldPlaque.requestFocus();

            JOptionPane.showMessageDialog(this, "Serviço Cadastrado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(this, "Houve um erro " + e.getMessage());
            e.printStackTrace();
        }






    }//GEN-LAST:event_jButtonaAddServiceActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        VehicleEditUi editUi = new VehicleEditUi(this, true);
        editUi.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButtonUpdateClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateClientsActionPerformed
        Session session = HibernateUtil.getSessionFactory().openSession();
        Dao<Person> genericDao = new GenericDao<Person>(session, false, Person.class);
        List<Person> list = genericDao.all();
        list = Person.patchList(list);
        Vector vector = new Vector(list);
        jComboBoxPersons.setModel(new javax.swing.DefaultComboBoxModel(vector));
        session.close();
    }//GEN-LAST:event_jButtonUpdateClientsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ManagerUi().setVisible(true);
            }
        });
    }
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private Vehicle vehicle = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonUpdateClients;
    private javax.swing.JButton jButtonaAddService;
    private javax.swing.JComboBox jComboBoxPersons;
    private javax.swing.JFormattedTextField jFormattedTextFieldDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelOwner;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDescription;
    private javax.swing.JTextField jTextFieldBrand;
    private javax.swing.JTextField jTextFieldKm;
    private javax.swing.JTextField jTextFieldModel;
    private javax.swing.JTextField jTextFieldPlaque;
    // End of variables declaration//GEN-END:variables
}
