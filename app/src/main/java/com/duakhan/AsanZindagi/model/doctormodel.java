package com.duakhan.AsanZindagi.model;

public class doctormodel {

    String username,time,fee;

    public doctormodel (){}

    public doctormodel(String username, String time, String fee) {
        this.username = username;
        this.time = time;
        this.fee = fee;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fees) {
        this.fee = fees;
    }
}
