package com.imooc.girl.domain;


import javax.persistence.*;

@Entity
@Table(name="mac")
public class Login {

    @Id
    private String macname;

    private String password;


    public String getMacname() {
        return macname;
    }

    public void setMacname(String macname) {
        this.macname = macname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
