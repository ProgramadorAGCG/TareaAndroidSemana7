package com.example.semana72;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class carrera extends Activity {
    EditText cod,carrera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrera);

        cod=(EditText) findViewById(R.id.txtcodP);
        carrera=(EditText) findViewById(R.id.txtcorP);
    }

    public void insertar(View v){
        dbmatricula gestion =new dbmatricula(this,"bdcarrera", null,1);
        SQLiteDatabase bd=gestion.getWritableDatabase();

        int codigo=Integer.parseInt(cod.getText()+"");
        String car=carrera.getText().toString();

        ContentValues registro=new ContentValues();
        registro.put("cod_carrera", codigo);
        registro.put("carrera", car);

        bd.insert("carrera", null, registro);
        bd.close();
        cod.setText("");
        carrera.setText("");

        Toast.makeText(this, "Se cargaron los datos", Toast.LENGTH_SHORT).show();
    }

    public void eliminar(View v){
        dbmatricula gestion=new dbmatricula(this,"bdcarrera", null,1);
        SQLiteDatabase bd=gestion.getWritableDatabase();
        int codigo=Integer.parseInt(cod.getText()+"");
        int cant = bd.delete("carrera", "cod_carrera=" + codigo, null);
        bd.close();
        cod.setText("");
        if(cant==1)
            Toast.makeText(this, "Se borraron los datos", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe el c�digo", Toast.LENGTH_SHORT).show();
    }

    public void consultadatos(View v){
        dbmatricula gestion = new dbmatricula(this,"bdcarrera", null,1);
        SQLiteDatabase bdatos=gestion.getWritableDatabase();
        String codigo=cod.getText()+"";

        Cursor fila=bdatos.rawQuery("select carrera from carrera where cod_carrera=" + codigo, null);

        if(fila.moveToFirst())
            carrera.setText(fila.getString(0));
        else
            Toast.makeText(this, "No existe el c�digo", Toast.LENGTH_SHORT).show();
        bdatos.close();
    }
    public void actualizar(View v){

        dbmatricula gestion=new dbmatricula(this,"bdcarrera", null,1);
        SQLiteDatabase bd=gestion.getWritableDatabase();

        int codigo=Integer.parseInt(cod.getText()+"");
        String car=carrera.getText().toString();

        ContentValues registro=new ContentValues();
        registro.put("cod_carrera",codigo);
        registro.put("carrera",car);

        int cant=bd.update("carrera", registro, "cod_carrera="+ codigo, null);
        if(cant==1)
            Toast.makeText(this, "Se modificaron los datos", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe el c�digo", Toast.LENGTH_SHORT).show();
    }
}
