package com.example.covidtracker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidtracker.models.Patient;



import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    //RecyclerView Adapter Class


        private final Context context;
        private final List<Patient> patients;

        public RecyclerAdapter(Context context, List<Patient> patients) {
            this.context = context;
            this.patients = patients;
        }

        @NonNull
        @Override
        public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.patient_layout, null, false);
            return new ViewHolder(v);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
            Patient patient = patients.get(position);
            holder.PatientName.setText(patient.getName());
            holder.PatientId.setText("Id: "+patient.getId());
            holder.PatientAge.setText("Age: "+patient.getAge());
            holder.PatientGender.setText("Gender: "+patient.getGender());
            holder.PatientLocation.setText("Location: "+patient.getLocation());
            holder.PatientTestDate.setText("Test Date: "+patient.getTestDate());
            holder.PatientResult.setText("Test Result: "+patient.getResult());


        }

        @Override
        public int getItemCount() {
            return patients.size();
        }

        //create ViewHolder class
        public static class ViewHolder extends RecyclerView.ViewHolder {
            TextView PatientName, PatientId, PatientLocation, PatientAge, PatientGender, PatientTestDate, PatientResult;

            public ViewHolder(View itemView) {
                super(itemView);
                PatientName = itemView.findViewById(R.id.viewPatientName);
                PatientId = itemView.findViewById(R.id.viewPatientId);
                PatientLocation = itemView.findViewById(R.id.ViewPatientLocation);
                PatientAge = itemView.findViewById(R.id.ViewPatientAge);
                PatientGender = itemView.findViewById(R.id.ViewPatientGender);
                PatientTestDate = itemView.findViewById(R.id.ViewPatientTestDate);
                PatientResult = itemView.findViewById(R.id.ViewPatientResult);
            }
        }

    }

