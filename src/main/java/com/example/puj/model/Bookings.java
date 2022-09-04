package com.example.puj.model;

public class Bookings extends Table {
    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;

    @Entity(type="VARCHAR", size=30, isnull = false)
    String name;

    @Entity(type="VARCHAR", size=30, isnull = false)
    String surname;

    @Entity(type="VARCHAR", size=30, isnull = false)
    String mail;

    @Entity(type="VARCHAR", size=30, isnull = false)
    String start;

    @Entity(type="VARCHAR", size=30, isnull = false)
    String destination;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
}
