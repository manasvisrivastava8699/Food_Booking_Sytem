package com.manasvi.Project.Entiry;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "foodcart")
public class BookFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bookingname")
    private String bookingname;

    @Email
    @Size(max = 50)
    @Column(name = "bookingemailId")
    private String bookingemailId;

    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "cost")
    private String cost;

    @Column(name = "quantity")
    private String quantity;

    public BookFood() {
    }


    public BookFood(int id, String bookingname, String bookingemailId, String name, String type, String cost, String quantity) {
        this.id = id;
        this.bookingname = bookingname;
        this.bookingemailId = bookingemailId;
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookingname() {
        return bookingname;
    }

    public void setBookingname(String bookingname) {
        this.bookingname = bookingname;
    }

    public String getBookingemailId() {
        return bookingemailId;
    }

    public void setBookingemailId(String bookingemailId) {
        this.bookingemailId = bookingemailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
