package com.example.smartphysicscalculator.ui.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartphysicscalculator.R;
import com.example.smartphysicscalculator.models.RVName;
import com.example.smartphysicscalculator.ui.adapters.NameAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NameAdapter.OnNameListener {

    private List<RVName> names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.rv_name);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        NameAdapter adapter = new NameAdapter(names, this);
        recyclerView.setAdapter(adapter);
    }

    private void setInitialData(){
        names.add(new RVName("Путь при равномерном движении"));
        names.add(new RVName("Уравнение скорости при равноускоренном движении"));
        names.add(new RVName("Второй закон Ньютона"));
        names.add(new RVName("Сила тяжести тела"));
        names.add(new RVName("Сила трения скольжения тела"));
        names.add(new RVName("Сила Архимеда"));
        names.add(new RVName("Сила Упругости"));
    }

    @Override
    public void onNameClick(int position) {
        names.get(position);
        Intent intent = new Intent(this, CalculationActivity.class);
        intent.putExtra(CalculationActivity.KEY_ACTIVITY, position);
        startActivity(intent);
    }
}
