package com.blospot.techscreator.caloriecalculator;


import android.support.design.widget.TextInputEditText;

/**
 * Created by Ananthu on 03-01-2018.
 */

public class User {
    public double getCal() {
        return cal;
    }

    public void setCal(double cal) {
        this.cal = cal;
    }

    public double cal;
    public  String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public  String gender;
    public String age;
    public String weight;
    public String hours;

    public User(int id,String name,String age, String gender, String weight, String hours,double cal) {
        this.name=name;
        this.id=id;
        this.age=age;
        this.gender=gender;
        this.weight=weight;
        this.hours=hours;
        this.cal=cal;
    }
    public User(){

    }


}