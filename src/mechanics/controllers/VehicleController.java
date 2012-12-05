/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics.controllers;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import mechanics.domain.Person;
import mechanics.domain.Vehicle;
import mechanics.gui.VehicleEditUi;
import mechanics.persistence.Dao;
import mechanics.persistence.GenericDao;
import mechanics.persistence.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author rodrigo
 */
public class VehicleController {

    private VehicleEditUi ui;

    public VehicleController() {
    }

    public void initialize() {
        /*Session session = HibernateUtil.getSessionFactory().openSession();
        Dao dao = new GenericDao(session,true,Person.class);
        List<Person> clients=dao.all();
        if(clients != null){
        for(int i=0; i<clients.size(); i++){
        this.ui.getjComboBoxOwner().addItem(clients.get(i));
        }

        }*/
    }

    public void onCreate() throws Exception {
        if (this.ui == null) {
            throw new Exception("Attribute VehicleEditUi needs to be initialized");
        }

        String plaque = this.ui.getjTextFieldPlaque().getText();

        if (Vehicle.isExists(plaque) == true) {
            JOptionPane.showMessageDialog(this.ui, "Veículo com a placa " + plaque + " já está cadastrado");
            return;
        }
        String brand = this.ui.getjTextFieldBrand().getText();
        String color = this.ui.getjTextFieldColor().getText();
        String model = this.ui.getjTextFieldModel().getText();
        //Person p = (Person)this.ui.getjComboBoxOwner().getSelectedItem();
        String year = this.ui.getjFormattedTextFieldYear1().getText() + " / "
                + this.ui.getjFormattedTextFieldYear2().getText();

        String notes = this.ui.getjTextAreaNotes().getText();




        Vehicle vehicle = new Vehicle(plaque, color, brand, model, year, notes);

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Dao dao = new GenericDao(session, true, Vehicle.class);
            dao.saveOrUpdate(vehicle);
            JOptionPane.showMessageDialog(this.ui, "Veículo cadastrado");
        }catch(HibernateException e){
            JOptionPane.showMessageDialog(this.ui, "Houve um erro na hora de salvar: \n"+e.getMessage());
        }


    }


    public VehicleEditUi getUi() {
        return ui;
    }

    public void setUi(VehicleEditUi ui) {
        this.ui = ui;
    }


}
