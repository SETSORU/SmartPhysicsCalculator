package com.example.smartphysicscalculator.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.smartphysicscalculator.R;
import com.example.smartphysicscalculator.models.RVName;
import com.example.smartphysicscalculator.ui.NameAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<RVName> names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.rv_name);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        NameAdapter adapter = new NameAdapter(names);
        recyclerView.setAdapter(adapter);
    }

    private void setInitialData(){
        names.add(new RVName("Расстояние","S=Vt"));
    }
}
