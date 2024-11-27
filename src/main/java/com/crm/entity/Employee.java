package com.crm.entity;


import jakarta.persistence.*;
import lombok.Getter;


@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "emp_name" ,nullable= false,length=255 )
    private String name;

    @Column(name = "emp_id" ,nullable= false,length=255,unique = true)
    private String emailId;

    @Column(name = "emp_mobile", nullable= false,length=255)
    private String mobile;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
