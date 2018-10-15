package com.example;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Product")
public class Product {

    @XmlElement(name = "id")
    private int id;

    @XmlElement(name = "name")
    private String name;
    
    @XmlElement(name = "price")
    private Double price;

    @XmlElement(name = "avail")
    private boolean avail;
    
    public Product() {
        super();
    }

    public Product(int id, String name, Double price, boolean available) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.avail = available;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isAvail() {
        return this.avail;
    }

    public void setAvail(boolean available) {
        this.avail = available;
    }
}
