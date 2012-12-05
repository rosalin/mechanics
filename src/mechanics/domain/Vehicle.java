/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mechanics.persistence.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author rodrigo
 */
public class Vehicle {

    private Long id;
    private String plaque;
    private String color;
    //private List<Person> client = new ArrayList<Person>();
    private String brand;
    private String model;
    private String year;
    private List<Service> services = new ArrayList<Service>(0);
    private String notes;

    public Vehicle() {
    }

    public Vehicle(String plaque, String color, String brand, String model, String year, String notes) {
        this.plaque = plaque;
        this.color = color;
        this.model = model;
        this.year = year;
        this.notes = notes;
        this.brand = brand;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }



        

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Person getCurrentOwner(){
         List list = this.getServices();
         if(list == null)
            return null;

         int size = list.size();

         if (size>0)
            return ((Service)list.get(size-1)).getOwner();
         else
            return null;
    }





   public static boolean isExists(String plaque) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = ("from Vehicle as v where v.plaque = " + "\'" + plaque + "\'");
        Query q = session.createQuery(hql);

        if (q.list().isEmpty()) {
            session.close();
            return false;
        }

        session.close();
        return true;
    }


     
   
}
