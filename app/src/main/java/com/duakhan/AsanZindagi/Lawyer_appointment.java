package com.duakhan.AsanZindagi;

public class Lawyer_appointment {
    String  Username, serid, Serviceprovidername,Time ,status, Date, fee, Uid ;

    public Lawyer_appointment(){}

    public Lawyer_appointment(String username, String serid, String serviceprovidername, String time, String status, String date, String fee, String uid) {
        this.Username = username;
        this.serid = serid;
        this.Serviceprovidername = serviceprovidername;
        this.Time = time;
        this.status = status;
        this.Date = date;
        this.fee = fee;
        this.Uid = uid;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getSerid() {
        return serid;
    }

    public void setSerid(String serid) {
        this.serid = serid;
    }

    public String getServiceprovidername() {
        return Serviceprovidername;
    }

    public void setServiceprovidername(String serviceprovidername) {
        Serviceprovidername = serviceprovidername;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }
}
