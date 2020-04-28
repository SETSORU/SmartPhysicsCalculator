package com.example.smartphysicscalculator.ui.adapters;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.smartphysicscalculator.R;
import com.example.smartphysicscalculator.ui.base.BaseFragment;

import java.util.List;


public class SectionsPagerAdapter extends FragmentPagerAdapter {


    private List<BaseFragment> fragments;

    public void setList(List<BaseFragment> fragments) {
        this.fragments = fragments;
        notifyDataSetChanged();
    }

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
       return fragments.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getName();
    }

    @Override
    public int getCount() {

        return fragments.size();
    }
}