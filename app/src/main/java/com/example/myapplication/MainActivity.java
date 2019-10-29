package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button ingresar;
    private TextView registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl ();
    }
    private void initControl () {
        ingresar = ( Button ) findViewById(R.id.ingresar);
        registrar = ( TextView ) findViewById(R.id.registar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ingresar:
                break;

            case R.id.registar:
                break;
        }

    }
}
