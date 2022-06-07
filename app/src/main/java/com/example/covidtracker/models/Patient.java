package com.example.covidtracker.models;

public class Patient {
    private int id;
    private String name, location, gender, age, result;
    private String testdate;
    public Patient(String name, String location, String gender, String age, String result, String testdate) {
        this.name = name;
        this.location = location;
        this.gender = gender;
        this.age = age;
        this.result = result;
        this.testdate = testdate;
    }
    public Patient(int id, String name, String location, String gender, String age, String result, String testdate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.gender = gender;
        this.age = age;
        this.result = result;
        this.testdate = testdate;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }

    public String getTestDate() { return testdate; }
    public void setTestDate(String testdate) { this.testdate = testdate; }
}
