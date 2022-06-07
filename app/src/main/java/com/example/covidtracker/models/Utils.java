package com.example.covidtracker.models;

public class Utils {
    //constant patient fields
    public static final String DATABASE_NAME = "COVID_DATA";
    public static final String TABLE_NAME = "PatientRecord";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String GENDER = "gender";
    public static final String LOCATION = "location";
    public static final String TESTDATE = "testdate";
    public static final String RESULT = "result";


   //creation of patient schema sql statement
    public static final String CREATE_PATIENT_TABLE= "CREATE TABLE " + TABLE_NAME + "( " +
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAME + " TEXT," +
            LOCATION + " TEXT, " +
            GENDER +" TEXT, "+
            AGE +" TEXT, " +
            RESULT + " TEXT, "+
            TESTDATE + " INTEGER)" ;
}
