package com.example.puj.model;

public class Reservation extends Table{
    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;
    @Entity(type="VARCHAR", size=30, isnull = false)
    String username;
    @Entity(type = "INTEGER", size = 32)
    int code;
    @Entity(type = "INTEGER", size = 32)
    int price;
    @Entity(type="VARCHAR", size=30, isnull = false)
    String start;
    @Entity(type="VARCHAR", size=30, isnull = false)
    String destination;
    @Entity(type = "INTEGER", size = 32)
    @ForeignKey(table = "Flight", attribute = "id")
    int flight_fk;
    @Entity(type = "INTEGER", size = 32)
    @ForeignKey(table = "Passanger", attribute = "id")
    int passanger_fk;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public Flight getFlight() throws Exception {
        return (Flight) Table.get(Flight.class, flight_fk );
    }

    public void setFlight_fk(int flight_fk) {
        this.flight_fk = flight_fk;
    }

    public Passanger getPassanger() throws Exception {
        return (Passanger) Table.get(Passanger.class,passanger_fk) ;
    }

    public void setPassanger_fk(int passanger_fk) {
        this.passanger_fk = passanger_fk;
    }
}
