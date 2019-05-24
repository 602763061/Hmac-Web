package com.imooc.girl.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name="girl")
public class Girl {


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupsize() {
        return cupsize;
    }

    public void setCupsize(String cupsize) {
        this.cupsize = cupsize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Id
    @GeneratedValue
    private Integer id;

    private String cupsize;


    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupsize='" + cupsize + '\'' +
                ", age=" + age +
                '}';
    }

    @Min(value = 18,message = "未成年少女不得入内")
    private Integer age;

    public Girl() {
    }
}
