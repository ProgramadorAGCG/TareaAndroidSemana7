package com.example.semana72;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class alumno extends Activity {
    EditText cod,alum,direc,corr,cel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);

        cod=(EditText) findViewById(R.id.txtcodA);
        alum=(EditText) findViewById(R.id.txtalumA);
        direc=(EditText) findViewById(R.id.txtdireA);
        corr=(EditText) findViewById(R.id.txtcorrA);
        cel=(EditText) findViewById(R.id.txtcelA);

    }
    public void insertar(View v){
        dbmatricula gestion =new dbmatricula(this,"bdalumno", null,1);
        SQLiteDatabase bd=gestion.getWritableDatabase();
        int codigo=Integer.parseInt(cod.getText()+"");
        String alumno=alum.getText().toString();
        String direcion=direc.getText().toString();
        String correo=corr.getText().toString();
        int celular=Integer.parseInt(cel.getText()+"");

        ContentValues registro=new ContentValues();
        registro.put("cod_alu", codigo);
        registro.put("nom_alu", alumno);
        registro.put("dir_alu", direcion);
        registro.put("correo", correo);
        registro.put("celular", celular);

        bd.insert("alumno", null, registro);
        bd.close();
        cod.setText("");
        alum.setText("");
        direc.setText("");
        corr.setText("");
        cel.setText("");

        Toast.makeText(this, "Se cargaron los datos", Toast.LENGTH_SHORT).show();
    }

    public void eliminar(View v){
        dbmatricula gestion=new dbmatricula(this,"bdalumno", null,1);
        SQLiteDatabase bd=gestion.getWritableDatabase();
        int codigo=Integer.parseInt(cod.getText()+"");
        int cant = bd.delete("alumno", "cod_alu=" + codigo, null);
        bd.close();
        cod.setText("");
        if(cant==1)
            Toast.makeText(this, "Se borraron los datos", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe el c�digo", Toast.LENGTH_SHORT).show();
    }

    public void consultadatos(View v){
        dbmatricula gestion=new dbmatricula(this,"bdalumno", null,1);
        SQLiteDatabase bdatos=gestion.getWritableDatabase();
        String codigo=cod.getText()+"";

        Cursor fila=bdatos.rawQuery("select nom_alu , dir_alu, correo , celular from alumno where cod_alu=" + codigo,null);
        if(fila.moveToFirst()){
            alum.setText(fila.getString(0));
            direc.setText(fila.getString(1));
            corr.setText(fila.getString(2));
            cel.setText(fila.getString(3));

        }
        else
            Toast.makeText(this, "No existe el c�digo", Toast.LENGTH_SHORT).show();
        bdatos.close();

    }

    public void actualizar(View v){
        dbmatricula gestion=new dbmatricula(this,"bdalumno", null,1);
        SQLiteDatabase bd=gestion.getWritableDatabase();

        int codigo=Integer.parseInt(cod.getText()+"");
        String alumno=alum.getText().toString();
        String direccion=direc.getText().toString();
        String correo=corr.getText().toString();
        int celular=Integer.parseInt(cel.getText()+"");

        ContentValues registro=new ContentValues();
        registro.put("nom_alu",alumno);
        registro.put("dir_alu",direccion);
        registro.put("correo",correo);
        registro.put("celular", celular);

        int cant=bd.update("alumno", registro, "cod_alu="+ codigo, null);
        if(cant==1)
            Toast.makeText(this, "Se modificaron los datos", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe el código", Toast.LENGTH_SHORT).show();
    }
}
