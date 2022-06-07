package com.example.covidtracker.models;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Action {
    //create a new record in the table patient
    static public int createPatient(Context context, Patient patient) {
        myDbHelper conn = new myDbHelper(context, Utils.DATABASE_NAME, null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Utils.NAME, patient.getName());
        values.put(Utils.LOCATION, patient.getLocation());
        values.put(Utils.GENDER, patient.getGender());
        values.put(Utils.AGE, patient.getAge());
        values.put(Utils.RESULT, patient.getResult());
        values.put(Utils.TESTDATE, patient.getTestDate());
        Long id = db.insert(Utils.TABLE_NAME, null, values);
        if (id != -1) {
            db = conn.getReadableDatabase();
            String[] protectedFields = {Utils.ID};
            Cursor cursor = db.query(Utils.TABLE_NAME, protectedFields, null, null, null, null, null);
            cursor.moveToLast();
            int idPatient = cursor.getInt(0);
            db.close();
            return idPatient;

        }

        db.close();
        return  -1;

   }
    static public ArrayList<Patient> findAll(Context context) {
        myDbHelper conn = new myDbHelper(context, Utils.DATABASE_NAME, null, 1);
        ArrayList<Patient> patients = new ArrayList<>();
        Patient patient;
        SQLiteDatabase db = conn.getReadableDatabase();
        Cursor cursor = db.query(Utils.TABLE_NAME, null, null, null, null, null, Utils.ID + " DESC");
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String location = cursor.getString(2);
                String gender = cursor.getString(3);
                String age = cursor.getString(4);
                String result = cursor.getString(5);
                String testdate = cursor.getString(6);
                patient = new Patient(id, name, location, gender, age, result, testdate);
                patients.add(patient);
            } while (cursor.moveToNext());
        }
        db.close();
        return patients;
    }
}
