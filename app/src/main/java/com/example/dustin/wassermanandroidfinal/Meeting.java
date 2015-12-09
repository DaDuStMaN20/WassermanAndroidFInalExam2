package com.example.dustin.wassermanandroidfinal;

/**
 * Created by Dustin on 12/8/15.
 */
public class Meeting {
    private int _id;
    private String name;
    private String description;
    private String location;
    private String date;
    private String time;
    private int _hostid;

    public Meeting(String name, String description, String location, String date, String time, int _hostid) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
        this.time = time;
        this._hostid = _hostid;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int get_hostid() {
        return _hostid;
    }

    public void set_hostid(int _hostid) {
        this._hostid = _hostid;
    }
}
