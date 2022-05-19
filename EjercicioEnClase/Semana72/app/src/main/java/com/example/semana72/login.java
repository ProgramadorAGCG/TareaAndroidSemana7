package com.example.semana72;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.content.Intent;

public class login extends Activity {
    EditText contra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        contra=(EditText) findViewById(R.id.txtlog);
        final Button button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (contra.getText().toString().equals("administrador"))
                    startActivity(new Intent(login.this,MainActivity.class));
                else
                    Toast.makeText(button1.getContext(),"Error",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
