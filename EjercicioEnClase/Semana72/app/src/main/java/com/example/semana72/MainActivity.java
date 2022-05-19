package com.example.semana72;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button alumno=(Button)findViewById(R.id.button1);
		Button carrera=(Button)findViewById(R.id.button2);
		Button prof=(Button)findViewById(R.id.button3);
		Button curs=(Button)findViewById(R.id.button4);
	
		alumno.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this,alumno.class));
			}
		});

        carrera.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			startActivity(new Intent(MainActivity.this, carrera.class));
			}
		});

        prof.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			startActivity(new Intent(MainActivity.this, profesores.class));
			}
		});

        curs.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			startActivity(new Intent(MainActivity.this, curso.class));
			}
		});
	}
}
