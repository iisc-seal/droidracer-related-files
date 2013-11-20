package com.example.appreceivecall;

import java.io.Serializable;

@SuppressWarnings("serial") //with this annotation we are going to hide compiler warning
public class Deneme implements Serializable {

public Deneme(double id, String name){
    this.id = id;
    this.name = name;
}

public double getId() {
    return id;
}
public void setId(double id) {
    this.id = id;
}
public String getName() {
    return this.name;
}
public void setName(String name) {
    this.name = name;
}

private double id;
private String name;

}