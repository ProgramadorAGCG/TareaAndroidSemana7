package com.example.problema7;

import android.os.Bundle;
import android.app.Activity;
import android.widget.EditText; //para usar cuadros de texto
import android.widget.Button; //para usar botones
import android.widget.Toast; //para mostrar mensajes "emergentes"
import android.view.View;
import android.content.Intent;
import android.net.Uri; //para llamar a un número de teléfono
import android.app.AlertDialog; //para mostrar mensaje de confirmación
import android.content.DialogInterface;


public class MainActivity extends Activity {
    EditText editNombre, editTelefono;
    private Button botonLlamar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTelefono = (EditText) findViewById(R.id.edtNum);
        botonLlamar = (Button) findViewById(R.id.btnLlamada);
        botonLlamar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Mostrar un mensaje de confirmación antes de realizar la llamada

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setMessage("¿Desea realizar la llamada al contacto?");
                alertDialog.setTitle("Llamar a contacto " + editTelefono.getText());
                alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
                alertDialog.setCancelable(false);
                alertDialog.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            editTelefono = (EditText) findViewById(R.id.edtNum);
                            String number = "tel:" + editTelefono.getText().toString().trim();
                            Toast.makeText(getApplicationContext(),
                                    "Llamando al " + editTelefono.getText().toString().trim(), Toast.LENGTH_LONG).show();
                            Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(number));
                            startActivity(callIntent);
                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(),
                                    "No se ha podido realizar la llamada", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),
                                "Llamada cancelada", Toast.LENGTH_LONG).show();
                    }
                });
                alertDialog.show();
            }
        });

    }

}
