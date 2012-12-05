/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics.domain;

import java.io.Serializable;

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
}
