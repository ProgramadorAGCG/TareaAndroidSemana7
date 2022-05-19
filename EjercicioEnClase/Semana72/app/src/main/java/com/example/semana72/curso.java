package com.example.semana72;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class curso extends Activity {
    EditText codcurs,codcar,codprof,nomcur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);

        codcurs=(EditText) findViewById(R.id.txtcodO);
        nomcur=(EditText) findViewById(R.id.txtnomO);
    }

    public void insertar(View v){
        dbmatricula gestion =new dbmatricula(this,"bdcursos", null,1);
        SQLiteDatabase bd=gestion.getWritableDatabase();

        int codigo=Integer.parseInt(codcurs.getText()+"");
        String nom=nomcur.getText().toString();

        ContentValues registro=new ContentValues();
        registro.put("cod_cursos", codigo);
        registro.put("nom_curso", nom);

        bd.insert("cursos", null, registro);
        bd.close();
        codcurs.setText("");
        nomcur.setText("");

        Toast.makeText(this, "Se cargaron los datos", Toast.LENGTH_SHORT).show();
    }

    public void eliminar(View v){
        dbmatricula gestion=new dbmatricula(this,"bdcursos", null,1);
        SQLiteDatabase bd=gestion.getWritableDatabase();
        int codigo=Integer.parseInt(codcurs.getText()+"");
        int cant = bd.delete("cursos", "cod_cursos=" + codigo, null);
        bd.close();
        codcurs.setText("");
        if(cant==1)
            Toast.makeText(this, "Se borraron los datos", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe el c�código", Toast.LENGTH_SHORT).show();
    }

    public void consultadatos(View v){
        dbmatricula gestion=new dbmatricula(this,"bdcursos", null,1);
        SQLiteDatabase bdatos=gestion.getWritableDatabase();
        String codigo=codcurs.getText().toString();
        Cursor fila=bdatos.rawQuery("select nom_curso from cursos where cod_cursos=" + codigo, null);
        if(fila.moveToFirst())
            nomcur.setText(fila.getString(0));
        else
            Toast.makeText(this, "No existe el código", Toast.LENGTH_SHORT).show();
        bdatos.close();
    }
    public void actualizar(View v){
        dbmatricula gestion=new dbmatricula(this,"bdcursos", null,1);
        SQLiteDatabase bd=gestion.getWritableDatabase();
        String codigo=codcurs.getText().toString();
        String nom=nomcur.getText().toString();

        ContentValues registro=new ContentValues();
        registro.put("nom_curso", nom);

        int cant=bd.update("cursos", registro, "cod_cursos="+ codigo, null);
        if(cant==1)
            Toast.makeText(this, "Se modificaron los datos", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe el código", Toast.LENGTH_SHORT).show();
    }
}
