package com.example.covidtracker.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidtracker.R;
import com.example.covidtracker.RecyclerAdapter;
import com.example.covidtracker.databinding.FragmentSlideshowBinding;
import com.example.covidtracker.models.Action;
import com.example.covidtracker.models.Patient;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    RecyclerView recyclerView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slideshow, container, false);

        //Anchoring the view components with the logic part
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_students);

        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));

        //Retrieving the information from the database
        ArrayList<Patient> list = Action.findAll(view.getContext());

        if(list.size() == 0){
            Toast.makeText(view.getContext(), "No records to show", Toast.LENGTH_LONG).show();
        }else{

            //Setting the Adapter
            RecyclerAdapter adapter = new RecyclerAdapter(view.getContext(), list);
            LinearLayoutManager manager = new LinearLayoutManager(view.getContext());
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(manager);
            recyclerView.setAdapter(adapter);
        }

        return view;
    }
}