/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ServiceEditUi.java
 *
 * Created on 06/12/2012, 13:13:45
 */
package mechanics.gui;

import com.mchange.v2.log.log4j.Log4jMLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import mechanics.domain.Person;
import mechanics.domain.Service;
import mechanics.domain.Vehicle;
import mechanics.persistence.Dao;
import mechanics.persistence.GenericDao;
import mechanics.persistence.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author rodrigo
 */
public class ServiceEditUi extends javax.swing.JDialog {

    /** Creates new form ServiceEditUi */
    public ServiceEditUi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }

    /** Creates new form ServiceEditUi */
    public ServiceEditUi(java.awt.Frame parent, boolean modal, Service service) {
        super(parent, modal);
        initComponents();
        this.service = service;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Dao<Person> genericDao = new GenericDao<Person>(session, false, Person.class);
        List<Person> list = genericDao.all();
        Vector vector = new Vector(list);
        //inicializa combo_box
        jComboBoxPersons.setModel(new javax.swing.DefaultComboBoxModel(vector));


        initDisplay();
    }

    private void initDisplay() {

        //initialize service dates
        jTextAreaDescription.setText(service.getDescription());

        String km = String.valueOf(service.getKm());

        if(km!=null)
          jTextFieldKm.setText(String.valueOf(service.getKm()));


        jComboBoxPersons.setSelectedItem(service.getOwner());
        jFormattedTextFieldDate.setText(formatter.format(service.getCreatedAt()));

        Vehicle vehicle = service.getVehicle();

        if (vehicle != null) {
            jTextFieldBrand.setText(vehicle.getBrand());
            jTextFieldColor.setText(vehicle.getColor());
            jTextFieldModel.setText(vehicle.getModel());
            jTextFieldPlaque.setText(vehicle.getPlaque());
            jFormattedTextFieldYear1.setText(vehicle.getYear().substring(0, 5));
            jFormattedTextFieldYear2.setText(vehicle.getYear().substring(7, 11));
            JOptionPane.showMessageDialog(this, "VALOR ANO: " + vehicle.getYear());

            Person person = vehicle.getCurrentOwner();
            if (person != null) {
                jTextFieldOwner.setText(person.getName());
            }
        }else{
            System.out.println("NULLLLL");
        }


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
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldKm = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxPersons = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        try{
            MaskFormatter mfDate = new MaskFormatter("##/##/####");
            jFormattedTextFieldDate = new javax.swing.JFormattedTextField(mfDate);
            jButtonaAddService = new javax.swing.JButton();
            jButtonaAddService1 = new javax.swing.JButton();
            jPanel4 = new javax.swing.JPanel();
            jLabel2 = new javax.swing.JLabel();
            jLabel1 = new javax.swing.JLabel();
            jTextFieldBrand = new javax.swing.JTextField();
            jTextFieldModel = new javax.swing.JTextField();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            jLabel5 = new javax.swing.JLabel();
            jTextFieldColor = new javax.swing.JTextField();
            jLabel7 = new javax.swing.JLabel();
            jTextFieldPlaque = new javax.swing.JTextField();
            try{
                MaskFormatter mf = new MaskFormatter("####");
                jFormattedTextFieldYear1 = new javax.swing.JFormattedTextField(mf);
                jFormattedTextFieldYear2 = new javax.swing.JFormattedTextField(mf);
                jLabelOwner = new javax.swing.JLabel();
                jTextFieldOwner = new javax.swing.JTextField();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setTitle("Serviço");

                jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Serviço"));

                jTextAreaDescription.setColumns(20);
                jTextAreaDescription.setEditable(false);
                jTextAreaDescription.setRows(5);
                jScrollPane1.setViewportView(jTextAreaDescription);

                jLabel6.setText("Descrição do serviço");

                jLabel9.setText("Km Atual:");

                jTextFieldKm.setEditable(false);

                jLabel10.setText("Proprietário:");

                jComboBoxPersons.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o proprietário atual" }));

                jLabel8.setText("Data:");

            }catch(ParseException e){
                Log4jMLog.info(e.getMessage());
            }
            jFormattedTextFieldDate.setEditable(false);

            javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
            jPanel6.setLayout(jPanel6Layout);
            jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9)
                        .addComponent(jLabel8))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jFormattedTextFieldDate)
                        .addComponent(jTextFieldKm, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addComponent(jLabel10)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jComboBoxPersons, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(331, Short.MAX_VALUE))
            );
            jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jComboBoxPersons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jFormattedTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addContainerGap())
            );

            jButtonaAddService.setText("Editar");
            jButtonaAddService.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonaAddServiceActionPerformed(evt);
                }
            });

            jButtonaAddService1.setText("Salvar");
            jButtonaAddService1.setEnabled(false);
            jButtonaAddService1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonaAddService1ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
            jPanel5.setLayout(jPanel5Layout);
            jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jButtonaAddService, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(680, 680, 680)
                                .addComponent(jButtonaAddService1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(23, 23, 23))
            );
            jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel6)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonaAddService, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonaAddService1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(13, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(169, Short.MAX_VALUE))
            );

            jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dados do Veículo"));

            jLabel2.setText("Modelo");

            jLabel1.setText("Marca");

            jTextFieldBrand.setEditable(false);

            jTextFieldModel.setEditable(false);

            jLabel3.setText("Ano");

            jLabel4.setText("/");

            jLabel5.setText("Cor");

            jTextFieldColor.setEditable(false);

            jLabel7.setText("Placa");

            jTextFieldPlaque.setEditable(false);

        }catch(ParseException e){
            JOptionPane.showMessageDialog(this,"Formato do campo deve ser dddd","alerta",JOptionPane.ERROR_MESSAGE);
        }
        jFormattedTextFieldYear1.setEditable(false);

        jFormattedTextFieldYear2.setEditable(false);

        jLabelOwner.setText("Proprietário");

        jTextFieldOwner.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelOwner)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextFieldOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jTextFieldBrand, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jTextFieldModel, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
                            .addContainerGap())
                        .addComponent(jTextFieldPlaque, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jTextFieldColor, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jFormattedTextFieldYear1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jLabel4)
                            .addGap(10, 10, 10)
                            .addComponent(jFormattedTextFieldYear2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldPlaque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jFormattedTextFieldYear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jFormattedTextFieldYear2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOwner)
                    .addComponent(jTextFieldOwner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(381, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(102, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonaAddService1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonaAddService1ActionPerformed
     
    }//GEN-LAST:event_jButtonaAddService1ActionPerformed

    private void jButtonaAddServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonaAddServiceActionPerformed
        jTextFieldKm.requestFocus();
        jTextAreaDescription.setEditable(true);
        jTextFieldKm.setEditable(true);
        jComboBoxPersons.setEditable(true);
        jFormattedTextFieldDate.setEditable(true);
        jButtonaAddService1.setEnabled(true);
        jButtonaAddService.setEnabled(false);
    }//GEN-LAST:event_jButtonaAddServiceActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                ServiceEditUi dialog = new ServiceEditUi(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    private Service service = null;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonaAddService;
    private javax.swing.JButton jButtonaAddService1;
    private javax.swing.JComboBox jComboBoxPersons;
    private javax.swing.JFormattedTextField jFormattedTextFieldDate;
    private javax.swing.JFormattedTextField jFormattedTextFieldYear1;
    private javax.swing.JFormattedTextField jFormattedTextFieldYear2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelOwner;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDescription;
    private javax.swing.JTextField jTextFieldBrand;
    private javax.swing.JTextField jTextFieldColor;
    private javax.swing.JTextField jTextFieldKm;
    private javax.swing.JTextField jTextFieldModel;
    private javax.swing.JTextField jTextFieldOwner;
    private javax.swing.JTextField jTextFieldPlaque;
    // End of variables declaration//GEN-END:variables
}