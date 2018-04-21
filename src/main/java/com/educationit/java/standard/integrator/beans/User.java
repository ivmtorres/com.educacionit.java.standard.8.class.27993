
package com.educationit.java.standard.integrator.beans;


public class User {

    private String login;

    private String password;

    private boolean enabled;


    public User () {

        super ();
    }


    public User (String login, String password, boolean enabled) {

        super ();

        this.login = login;
        this.password = password;
        this.enabled  = enabled;
    }

    public String getLogin () {
        return login;
    }

    public void setLogin (String login) {

        this.login = login;
    }

    public String getPassword () {

        return password;
    }

    public void setPassword (String password) {

        this.password = password;
    }

    public boolean isEnabled () {

        return enabled;
    }

    public void setEnabled (boolean enabled) {

        this.enabled = enabled;
    }
}