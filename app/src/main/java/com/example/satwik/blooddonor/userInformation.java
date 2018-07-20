package com.example.satwik.blooddonor;

/**
 * Created by satwik on 26-03-2018.
 */

public class userInformation {

    public String _username;
    public String _password;
    public String _retype_pwd;
    public String _name;
    public String _city;
    public String _state;
    public String _mobile;
    public String _bloodgroup;
    public String _Age;
    public String _emailid;
    public String _permanentAddress;

    public userInformation(String _username, String _password, String _retype_pwd, String _name, String _city, String _state, String _mobile, String _bloodgroup, String _Age, String _emailid, String _permanentAddress) {
        this._username = _username;
        this._password = _password;
        this._retype_pwd = _retype_pwd;
        this._name = _name;
        this._city = _city;
        this._state = _state;
        this._mobile = _mobile;
        this._bloodgroup = _bloodgroup;
        this._Age = _Age;
        this._emailid = _emailid;
        this._permanentAddress = _permanentAddress;
    }

    public String get_username() {
        return _username;
    }

    public String get_password() {
        return _password;
    }

    public String get_retype_pwd() {
        return _retype_pwd;
    }

    public String get_name() {
        return _name;
    }

    public String get_city() {
        return _city;
    }

    public String get_state() {
        return _state;
    }

    public String get_mobile() {
        return _mobile;
    }

    public String get_bloodgroup() {
        return _bloodgroup;
    }

    public String get_Age() {
        return _Age;
    }

    public String get_emailid() {
        return _emailid;
    }

    public String get_permanentAddress() {
        return _permanentAddress;
    }
}
