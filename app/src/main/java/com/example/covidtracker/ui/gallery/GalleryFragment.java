package com.example.covidtracker.ui.gallery;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.covidtracker.R;
import com.example.covidtracker.databinding.FragmentGalleryBinding;
import com.example.covidtracker.models.Action;
import com.example.covidtracker.models.Patient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class GalleryFragment extends Fragment {

    EditText txtName, txtAge, txtGender, txtLocation, txtTestDate;
    Spinner dropDown;
    ListView lvResult;
    Button btSubmit;
    ArrayList<String> results;
    Action action;
    int resultPosition = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gallery,container,false);

        txtName = view.findViewById(R.id.txt_name);
        txtAge = view.findViewById(R.id.txt_age);
        txtGender = view.findViewById(R.id.txt_gender);
        txtLocation = view.findViewById(R.id.txt_location);
        txtTestDate = view.findViewById(R.id.txt_testdate);
        dropDown = view.findViewById(R.id.spinner1);
        btSubmit = view.findViewById(R.id.bt_submit);

        //initializing list of results
        results = new ArrayList<>(Arrays.asList("Choose Result","Positive","Negative"));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1,results);
        dropDown.setAdapter(arrayAdapter);

        dropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                resultPosition = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertPatient();
            }
        });

        return view;
    }

    //insert new patient
    private void insertPatient() {
        String name = txtName.getText().toString();
        String age = txtAge.getText().toString();
        String gender = txtGender.getText().toString();
        String location = txtLocation.getText().toString();
        String date = txtTestDate.getText().toString();

        if(name.equals("") || age.equals("") || gender.equals("") || location.equals("") || date.equals("") || resultPosition == 0){
            if (name.equals(""))
                txtName.setError("Name is Required");
            else if(age.equals(""))
                txtAge.setError("Age is Required");
            else if(gender.equals(""))
                txtGender.setError("Gender is Required");
            else if(location.isEmpty())
                txtLocation.setError("Location is Required");
            else if(date.equals(""))
                txtTestDate.setError("Date is Required");
            else
            {
                    //Show message in AlertDialog
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Please select the result");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
            }
        }
        else{

            //Creating Patient Object
            Patient patient = new Patient(name,
                    location,
                    gender,
                    age,
                    results.get(resultPosition),
                    date
                    );

            //Invoking createPatient method from Action class
            int id = Action.createPatient(getContext(), patient);

            if(id != -1){
                Toast.makeText(getContext(), "Record saved Student id: " + id, Toast.LENGTH_LONG).show();
                txtName.getText().clear();
                txtAge.getText().clear();
                txtGender.getText().clear();
                txtLocation.getText().clear();
                dropDown.setPromptId(0);
            }else{
                Toast.makeText(getContext(), "Error when saving the information", Toast.LENGTH_LONG).show();
            }
        }


    }



}