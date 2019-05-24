package com.imooc.girl.domain;

public class HmacMessage {

    private String  macname;

    private String passname;

    public String getPassname() {
        return passname;
    }

    public void setPassname(String passname) {
        this.passname = passname;
    }

    //计算后的密码
    private String Message;

    public String getMacname() {
        return macname;
    }

    public void setMacname(String macname) {
        this.macname = macname;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
