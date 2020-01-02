package com.example.trainsearch.bean;

public class User {
    private int _id;
    private String userid;
    private String pwd;
    private String username;
    private String licensetype;
    private String licensenumber;
    private String passengertype;
    private String phonenumber;

    public User() {
    }

    public User(int _id, String userid, String pwd, String username, String licensetype, String licensenumber, String passengertype, String phonenumber) {
        this._id=_id;
        this.userid = userid;
        this.pwd = pwd;
        this.username = username;
        this.licensetype = licensetype;
        this.licensenumber = licensenumber;
        this.passengertype = passengertype;
        this.phonenumber = phonenumber;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLicensetype() {
        return licensetype;
    }

    public void setLicensetype(String licensetype) {
        this.licensetype = licensetype;
    }

    public String getLicensenumber() {
        return licensenumber;
    }

    public void setLicensenumber(String licensenumber) {
        this.licensenumber = licensenumber;
    }

    public String getPassengertype() {
        return passengertype;
    }

    public void setPassengertype(String passengertype) {
        this.passengertype = passengertype;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
