package com.imooc.girl.domain;

public class HmacInput {
    private String hmacType;

    public String getHmacMassage() {
        return hmacMassage;
    }

    public void setHmacMassage(String hmacMassage) {
        this.hmacMassage = hmacMassage;
    }

    private String hmacMassage;

    private String secretKey;

    public String getHmacType() {
        return hmacType;
    }

    public void setHmacType(String hmacType) {
        this.hmacType = hmacType;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
