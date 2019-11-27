package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.models.persona;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button ingresar;
    private TextView registrar;
    private Button registro;

    EditText usuario, contrasena;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl ();
    }
    private void initControl () {
        ingresar = ( Button ) findViewById(R.id.ingresar);
        registrar = ( TextView ) findViewById(R.id.registar);
        registro = ( Button ) findViewById(R.id.regis);

        usuario = findViewById(R.id.usua);
        contrasena = findViewById(R.id.contra);

        ingresar.setOnClickListener(this);
        registrar.setOnClickListener(this);
        registro.setOnClickListener(this);
        usuario.setOnClickListener(this);
        contrasena.setOnClickListener(this);

        inicializarFirebase();
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public void onClick(View v) {
        String user = usuario.getText().toString();
        String pass = contrasena.getText().toString();
        switch (v.getId()) {
            case R.id.ingresar:
                Intent intent = new Intent(v.getContext(), dashboard.class);
                startActivityForResult(intent, 0);
                break;

            case R.id.registar:
                Intent intent2 = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(intent2, 0);
                break;
            case R.id.regis:
                if (user.equals("") || pass.equals("")) {
                    validate();
                }else {
                    persona p = new persona();
                    p.setId(UUID.randomUUID().toString());
                    p.setUsuario(user);
                    p.setContraseña(pass);
                    databaseReference.child("Persona").child(p.getId()).setValue(p);
                }
        }

    }

    private void validate() {
        String user = usuario.getText().toString();
        String pass = contrasena.getText().toString();
        if (user.equals("")){
            usuario.setError("Requerido");
        }else if (pass.equals("")) {
            contrasena.setError("Requerido");
        }
    }
}
