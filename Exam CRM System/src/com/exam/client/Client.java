package com.exam.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    private int id;
    private String name;
    private String industry;
    private String contactPerson;
    private double revenue;

    private boolean active;

    public Client(){

    }

    public Client(int id, String name, String industry, String contactPerson, double revenue){
        this.id=id;
        this.name=name;
        this.industry=industry;
        this.contactPerson=contactPerson;
        this.revenue=revenue;
        this.active = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + "\nName: " + getName() + "\nIndustry: " + getIndustry() + "\nContact person: " + getContactPerson() + "\nRevenue: " + getRevenue();
    }

    public String toCSVString(){
        return getId() + ", " + getName() +", " + getIndustry() + ", " + getContactPerson()+ ", " + getRevenue();
    }
}
