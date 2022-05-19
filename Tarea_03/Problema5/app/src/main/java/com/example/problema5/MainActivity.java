package com.example.problema5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText txtLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.btnBuscar);
        txtLink = (EditText)findViewById(R.id.txtLink);
        search_youtube();
    }

    public void search_youtube() {
        button.setOnClickListener((View view) -> {
                Uri url = Uri.parse(txtLink.getText().toString());
                Intent intent = new Intent(Intent.ACTION_VIEW, url);
                startActivity(intent);
        });
    }
}