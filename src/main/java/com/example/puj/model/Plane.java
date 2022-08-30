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
}
