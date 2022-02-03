package com.sp.shelterleh;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ContactFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact,container,false);


    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        ImageView telegram = getView().findViewById(R.id.telegram);
        ImageView email = getView().findViewById(R.id.email);
        ImageView phone = getView().findViewById(R.id.phone);
        ImageView whatsapp = getView().findViewById(R.id.whatsapp);
        ImageView instagram = getView().findViewById(R.id.instagram);
        ImageView spotify = getView().findViewById(R.id.spotify);


        telegram.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try {
                    Intent telegramIntent = new Intent(Intent.ACTION_VIEW);
                    telegramIntent.setData(Uri.parse("http://telegram.me/Phernoix"));
                    startActivity(telegramIntent);

                } catch (Exception e) {

                }
            }
        });

        email.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:eklaseboer@gmail.com")));}

        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+6594760130"));
                startActivity(intent);
            }
        });
        whatsapp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String url = "https://api.whatsapp.com/send?phone=6594760130";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        instagram.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://instagram.com/phernoix");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        spotify.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://open.spotify.com/user/horriddeath"));
                startActivity(intent);
            }
        });
    }


}
