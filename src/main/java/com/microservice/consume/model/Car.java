package com.microservice.consume.model;

public class Car {
    private int id;
    private String brand;
    private String modele;

    public Car(int id, String brand, String modele) {
        this.id = id;
        this.brand = brand;
        this.modele = modele;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", modele='" + modele + '\'' +
                '}';
    }
}
