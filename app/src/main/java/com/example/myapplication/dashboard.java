package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dashboard extends AppCompatActivity implements View.OnClickListener {

    private Button actividad2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initControl ();
    }

    private void initControl() {
        actividad2 =  ( Button ) findViewById(R.id.activity2);

        actividad2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity2:
                Intent intent = new Intent(v.getContext(), Main2Activity.class);
                startActivityForResult(intent, 0);
                break;

        }
    }
}



