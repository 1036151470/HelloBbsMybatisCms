package com.hellobbs.database;

public class Forlink {
    private int id;
    private String adress;
    private String pics;
    private String name;

    public String getAddress() {
        return adress;
    }

    public void setAddress(String address) {
        this.adress = address;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Forlink{" +
                "id=" + id +
                ", address='" + adress + '\'' +
                ", pics='" + pics + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
