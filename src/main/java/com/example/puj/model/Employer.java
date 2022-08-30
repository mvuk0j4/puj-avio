package com.example.puj.model;

public class Employer extends Table{
    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;
    @Entity(type="VARCHAR", size=30, isnull = false)
    String name;
    @Entity(type="VARCHAR", size=30, isnull = false)
    String surname;
    @Entity(type="VARCHAR", size=30, isnull = false)
    String mail;
    @Entity(type = "INTEGER", size = 32)
    @ForeignKey(table = "Reservation", attribute = "id")
    int reservation_fk;

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

    public Reservation getReservation() throws Exception {
        return (Reservation) Table.get( Reservation.class,reservation_fk);
    }

    public void setReservation_fk(int reservation_fk) {
        this.reservation_fk = reservation_fk;
    }
}
