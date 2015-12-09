package com.example.dustin.wassermanandroidfinal;

/**
 * Created by Dustin on 12/8/15.
 */
public class Host {

    private int _id;
    private String email;

    public Host(String email) {
        this.email = email;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return (_id + "   " + email);
    }
}
