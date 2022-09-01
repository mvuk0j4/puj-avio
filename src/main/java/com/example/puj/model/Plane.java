package com.example.puj.model;

public class Plane extends Table{
    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;
    @Entity(type="VARCHAR", size=30, isnull = false)
    String name;
    @Entity(type = "INTEGER", size = 32)
    int year;
    @Entity(type = "INTEGER", size = 32)
    @ForeignKey(table = "Flight", attribute = "id")
    int flight_fk;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public Flight getFlight() throws Exception {
        return (Flight) Table.get(Flight.class, flight_fk );
    }

    public void setFlight_fk(int flight_fk) {
        this.flight_fk = flight_fk;
    }
}
