package com.example.smartphysicscalculator.ui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartphysicscalculator.R;
import com.example.smartphysicscalculator.models.RVName;

public class NameViewHolder extends RecyclerView.ViewHolder {
    TextView tv_item_name;
    TextView tv_item_formula;
    public NameViewHolder(@NonNull View itemView) {
        super(itemView);
       tv_item_name = itemView.findViewById(R.id.tv_item_name);
       tv_item_formula = itemView.findViewById(R.id.tv_item_formula);
    }
    public void onBind (RVName name){
        tv_item_name.setText(name.getName());
        tv_item_formula.setText(name.getFormula());
    }
}
