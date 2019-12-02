package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button inicio;
    private  Button resgistrarme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initControl ();
    }

    private void initControl() {
        inicio =  ( Button ) findViewById(R.id.ingresar);
        resgistrarme = ( Button ) findViewById(R.id.resgistrarme);

        inicio.setOnClickListener(this);
        resgistrarme.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.inicio:
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
                break;
            case R.id.registrar:
                Intent intent2 = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(intent2, 0);
                break;
        }
    }
}
