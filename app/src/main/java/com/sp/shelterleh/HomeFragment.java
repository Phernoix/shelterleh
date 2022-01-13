package com.sp.shelterleh;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment implements View.OnClickListener {
    FloatingActionButton myFab;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home,container,false);

        myFab = (FloatingActionButton) v.findViewById(R.id.gpsButton);
        myFab.setOnClickListener(this);
    return v;
    }


    @Override
    public void onClick(View v) {
        Toast.makeText(getContext(), "testing", Toast.LENGTH_SHORT).show();
    }
}
