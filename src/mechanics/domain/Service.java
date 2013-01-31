/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mechanics.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author rodrigo
 */
public class Service {
    private Long id;
    private String description;
    private long km;
    private double price;
    private Vehicle vehicle;
    //private DateTime data_servico
    private Person owner;
    private Date createdAt;


    public Service(){}

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public long getKm() {
        return km;
    }

    public void setKm(long km) {
        this.km = km;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double  price){
        this.price = price;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
