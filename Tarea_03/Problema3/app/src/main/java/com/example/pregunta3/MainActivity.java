package com.example.pregunta3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView txtCaja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tomarFoto();
    }

    public void tomarFoto() {
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener((View v)->{
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivity(intent);
            txtCaja.setText("Se activo la foto");
        });

    }
}