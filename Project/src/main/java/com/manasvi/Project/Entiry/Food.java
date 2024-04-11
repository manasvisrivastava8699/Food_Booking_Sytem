package com.manasvi.Project.Entiry;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotBlank(message = "Food Name must not be null")
    @Size(max = 20)
    @NotNull
    private String name;

    @Column(name = "type")
    private String type;


    @Column(name = "bookingemailId")
    private String bookingemailId;

    @Column(name = "cost")
    private String cost;

    public Food() {
    }

    public Food(int id, String name, String type, String cost, String bookingemailId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.bookingemailId = bookingemailId;
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

    public String getBookingemailId() {
        return bookingemailId;
    }

    public void setBookingemailId(String bookingemailId) {
        this.bookingemailId = bookingemailId;
    }

}
