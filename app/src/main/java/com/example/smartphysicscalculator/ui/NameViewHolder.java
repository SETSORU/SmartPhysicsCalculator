package com.example.smartphysicscalculator.ui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartphysicscalculator.R;
import com.example.smartphysicscalculator.models.RVName;

public class NameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView tv_item_name;
    NameAdapter.OnNameListener onNameListener;
    public NameViewHolder(@NonNull View itemView, NameAdapter.OnNameListener onNameListener) {
        super(itemView);
       tv_item_name = itemView.findViewById(R.id.tv_item_name);
       this.onNameListener = onNameListener;
       itemView.setOnClickListener(this);
    }
    public void onBind (RVName name){
        tv_item_name.setText(name.getName());
    }

    @Override
    public void onClick(View v) {
        onNameListener.onNameClick(getAdapterPosition());
    }
}
