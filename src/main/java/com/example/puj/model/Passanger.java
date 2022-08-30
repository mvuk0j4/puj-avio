package com.example.puj.model;

public class Passanger extends Table{
    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;
    @Entity(type="VARCHAR", size=30, isnull = false)
    String username;
    @Entity(type="VARCHAR", size=30, isnull = false)
    String password;
    @Entity(type="VARCHAR", size=30, isnull = false)
    String mail;
    @Entity(type = "INTEGER", size = 32)
    int type;
    @Entity(type="VARCHAR", size=30, isnull = false)
    String name;
    @Entity(type="VARCHAR", size=30, isnull = false)
    String surname;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

}
