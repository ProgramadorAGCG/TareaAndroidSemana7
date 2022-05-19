package com.example.problema1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,
            btn8,btn9,btn0,btnAsterisco,btnNumeral,btnDel,btnCall;
    TextView textView;
    StringBuilder fono = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById( R.id.txtTelefono );
        btnDel = (Button) findViewById( R.id.btnDelete );
        btn1 = (Button) findViewById( R.id.btnNum1 );
        btn2 = (Button) findViewById( R.id.btnNum2 );
        btn3 = (Button) findViewById( R.id.btnNum3 );
        btn4 = (Button) findViewById( R.id.btnNum4 );
        btn5 = (Button) findViewById( R.id.btnNum5 );
        btn6 = (Button) findViewById( R.id.btnNum6 );
        btn7 = (Button) findViewById( R.id.btnNum7 );
        btn8 = (Button) findViewById( R.id.btnNum8 );
        btn9 = (Button) findViewById( R.id.btnNum9 );
        btn0 = (Button) findViewById( R.id.btnNum0 );
        btnAsterisco = (Button) findViewById( R.id.btnAsterisco );
        btnNumeral = (Button) findViewById( R.id.btnNumeral );
        btnCall = (Button) findViewById( R.id.btnCall );
        btnDel.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnAsterisco.setOnClickListener(this);
        btnNumeral.setOnClickListener(this);
        btnCall.setOnClickListener(this);
        textView.setText("");
        fono.setLength(0);
        verificarPermisos();
    }

    private void verificarPermisos(){
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.i("Mensaje", "No se tiene permiso para realizar llamadas telefónicas.");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 225);
        } else {
            Toast.makeText(this,"Permiso concedido",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        //segun el boton que se presione, realiza la accion correspondiente
        switch ( v.getId() )
        {
            case R.id.btnNum1 : fono.append("1"); break;
            case R.id.btnNum2 : fono.append("2"); break;
            case R.id.btnNum3 : fono.append("3"); break;
            case R.id.btnNum4 : fono.append("4"); break;
            case R.id.btnNum5 : fono.append("5"); break;
            case R.id.btnNum6 : fono.append("6"); break;
            case R.id.btnNum7 : fono.append("7"); break;
            case R.id.btnNum8 : fono.append("8"); break;
            case R.id.btnNum9 : fono.append("9"); break;
            case R.id.btnNum0 : fono.append("0"); break;
            case R.id.btnNumeral : fono.append("#"); break;
            case R.id.btnAsterisco : fono.append("*"); break;
            case R.id.btnDelete: delete(); break;
            case R.id.btnCall: call(); break;
        }

        textView.setText(fono);
    }

    private void delete() {
        if( fono.length()>0 ) {
            fono.deleteCharAt(fono.length()-1);
        }
    }


    private void call() {
        try {
            if( fono.length()> 0) {
                Uri numero = Uri.parse( "tel:" + fono.toString() );
                Intent intent = new Intent(android.content.Intent.ACTION_CALL, numero);
                startActivity(intent);
            }
            else {
                Toast.makeText(getBaseContext(),"Debe escribir un numero de telefono",Toast.LENGTH_SHORT).show();
            }

        }
        catch (ActivityNotFoundException activityException) {
            Log.e("ET", "No se pudo realizar la llamada.", activityException);
        }

    }

}