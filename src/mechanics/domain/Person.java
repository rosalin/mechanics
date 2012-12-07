/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rodrigo
 */
public class Person {

    private long id;
    private String name;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.name;
    }


    public static List patchList(List<Person> list){
       int i;
       List<Person> newList = new ArrayList<Person>(0);

       for (i=0; i<list.size(); i++)
       {
           //JOptionPane.showMessageDialog(null, list.get(i));
           Person object = (Person) list.get(i);
           long id = object.getId();
           if ((id > 8)){
               newList.add(object);
           }
                           
       }

       return newList;
    }




}
