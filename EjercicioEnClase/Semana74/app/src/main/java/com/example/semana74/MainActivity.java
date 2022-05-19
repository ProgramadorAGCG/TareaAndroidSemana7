package com.example.semana74;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    Button enviar;
    TextInputEditText mensaje, numero;
    ProgressBar progressBar;
    TextView txt;
    Integer counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mensaje = findViewById(R.id.txtMensaje);
        numero = findViewById(R.id.txtNumero);
        txt = findViewById(R.id.txtProgress);
        enviar = findViewById(R.id.btnEnviar);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(10);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {
                    Manifest.permission.SEND_SMS
            }, 1000);
        }

        View.OnClickListener listener = new View.OnClickListener() {
            public void onClick(View view) {
                if (enviarMensaje(numero.getText().toString(), mensaje.getText().toString())) {
                    counter = 1;
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setProgress(0);
                    switch (view.getId()) {
                        case R.id.btnEnviar:
                            new MyAsyncTask().execute(11);
                            break;
                    }
                }
            }
        };
        enviar.setOnClickListener(listener);
    }

    class MyAsyncTask extends AsyncTask<Integer, Integer, String> {
        @Override
        protected String doInBackground(Integer... params) {
            for (; counter <= params[0]; counter++) {
                try {
                    Thread.sleep(500);
                    publishProgress(counter);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Mensaje enviado correctamente ✅";
        }

        @Override
        protected void onPostExecute(String result) {
            progressBar.setVisibility(View.GONE);
            txt.setText(result);
            enviar.setText("Reiniciar");
        }

        @Override
        protected void onPreExecute() {
            txt.setText("En progreso...");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            txt.setText("Enviando mensaje... " +  values[0]*10 + "%");
            progressBar.setProgress(values[0]);
        }
    }

    private boolean enviarMensaje(String numero, String mensaje) {
        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(numero,null,mensaje,null,null);
            return true;
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Mensaje no enviado, datos incorrectos.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
            return false;
        }
    }
}