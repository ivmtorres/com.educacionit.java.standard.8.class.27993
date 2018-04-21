
package com.educationit.java.standard.integrator.beans;

public class Store {

    private String id;

    private String name;


    public Store () {

        super ();
    }

    public Store (String id, String name) {

        super ();

        this.id = id;
        this.name = name;
    }


    public String getId () {

        return id;
    }

    public void setId (String id) {

        this.id = id;
    }

    public String getName () {

        return name;
    }

    public void setName (String name) {

        this.name = name;
    }
}