package com.duakhan.AsanZindagi.model;

public class user {

    String profilepic , Username , mail  , number ,  password , userid;

    public user(String profilepic,String number, String Username, String mail, String password, String userid) {
        this.profilepic = profilepic;
        this.Username = Username;
        this.mail = mail;
        this.password = password;
        this.userid = userid;
        this.number=number;
    }

    public  user(){}
    //SignUp Constrator

    public user(String mail, String number ,String password , String Username,String userid) {
        this.Username = Username;
        this.mail = mail;
        this.password = password;
        this.number=number;
        this.userid=userid;

    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
