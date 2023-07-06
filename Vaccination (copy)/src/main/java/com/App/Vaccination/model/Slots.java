package com.App.Vaccination.model;

import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Date;

@Entity
@Table(name = "slots")
public class Slots {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer slotId;

    private boolean isBooked = false;

    private Date date;

    private Integer userId;

    private Integer centreId;

    public Integer getSlotId() {
        return slotId;
    }

    public void setSlotId(Integer slotId) {
        this.slotId = slotId;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCentreId() {
        return centreId;
    }

    public void setCentreId(Integer centreId) {
        this.centreId = centreId;
    }
}
