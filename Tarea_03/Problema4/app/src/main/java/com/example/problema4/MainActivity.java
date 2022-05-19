package com.example.problema4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.view.View.OnClickListener;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Button bt_guardar;
    private TextView txt, txtResultado;
    private EditText ed_text;
    private SharedPreferences datos;
    private String valorLeido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_guardar = (Button)findViewById(R.id.button1);
        txt = (TextView)findViewById(R.id.textView1);
        ed_text = (EditText)findViewById(R.id.editText1);
        datos = getSharedPreferences("fichero_app", Context.MODE_PRIVATE);
        valorLeido = datos.getString("Mail",  "Dato no encontrado");
        txt.setText(valorLeido);
        bt_guardar.setOnClickListener((View view) -> {
                SharedPreferences.Editor editor = datos.edit();
                editor.putString("Mail", ed_text.getText().toString());
                editor.commit();
                txt.setText(datos.getString("Mail",  "Dato no encontrado"));
        });
    }
}