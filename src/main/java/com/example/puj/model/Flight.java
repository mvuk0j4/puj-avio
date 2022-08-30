package com.example.puj.model;

public class Flight extends Table{
    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;
    @Entity(type="VARCHAR", size=30, isnull = false)
    String start;
    @Entity(type="VARCHAR", size=30, isnull = false)
    String destination;
    @Entity(type = "INTEGER", size = 32)
    int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
