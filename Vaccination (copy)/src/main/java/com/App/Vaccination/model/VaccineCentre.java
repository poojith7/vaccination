package com.App.Vaccination.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "centre")
public class VaccineCentre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer centreId;

    private String city;

    private boolean isActive;

    private Date openingTime;

    private Date closingTime;

    public Integer getCentreId() {
        return centreId;
    }

    public void setCentreId(Integer centreId) {
        this.centreId = centreId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Date openingTime) {
        this.openingTime = openingTime;
    }

    public Date getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Date closingTime) {
        this.closingTime = closingTime;
    }
}
