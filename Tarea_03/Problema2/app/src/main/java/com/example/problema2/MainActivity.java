package com.example.problema2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView1.setOnClickListener((View v)->{
            Toast.makeText(getApplicationContext(), "Click primera imagen......", Toast.LENGTH_SHORT).show();
        });

        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setOnClickListener((View v)-> {
            Toast.makeText(getApplicationContext(), "Click segunda imagen......", Toast.LENGTH_SHORT).show();
        });

        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView3.setOnClickListener((View v)-> {
            Toast.makeText(getApplicationContext(), "Click tercera imagen......", Toast.LENGTH_SHORT).show();
        });
    }
}