package com.sp.shelterleh;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

public class HomeFragment extends Fragment {
    ExtendedFloatingActionButton addFab;
    FloatingActionButton inputFab, currentFab;
    TextView inputText, currentText, random_text;
    Boolean isAllFabsVisible;
    private String[] randomTip;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home,container,false);

        addFab = v.findViewById(R.id.addButton);
        inputFab = v.findViewById(R.id.input_location_fab);
        currentFab = v.findViewById(R.id.current_location_fab);
        random_text =v.findViewById(R.id.randomText);

        inputText = v.findViewById(R.id.input_location_text);
        currentText = v.findViewById(R.id.current_location_text);

        inputFab.setVisibility(View.GONE);
        currentFab.setVisibility(View.GONE);
        inputText.setVisibility(View.GONE);
        currentText.setVisibility(View.GONE);

        isAllFabsVisible = false;

        addFab.shrink();

        randomTip = getResources().getStringArray(R.array.random_tip);

        int randomIndex = new Random().nextInt(randomTip.length);
        String randomName = randomTip[randomIndex];
        random_text.setText(randomName);




        addFab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!isAllFabsVisible) {

                            inputFab.show();
                            currentFab.show();
                            inputText.setVisibility(View.VISIBLE);
                            currentText.setVisibility(View.VISIBLE);

                            addFab.extend();

                            isAllFabsVisible = true;
                        } else {

                            inputFab.hide();
                            currentFab.hide();
                            inputText.setVisibility(View.GONE);
                            currentText.setVisibility(View.GONE);

                            addFab.shrink();

                            isAllFabsVisible = false;
                        }
                    }
                });
        inputFab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(), MapsActivity.class);
                        startActivity(intent);
                    }
                });
        currentFab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(), MapsActivity.class);
                        startActivity(intent);
                    }
                });


        return v;
    }


}
