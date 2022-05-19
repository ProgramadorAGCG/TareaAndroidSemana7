package com.example.semana72;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class profesores extends Activity {
    EditText cod,nom,cel,dir,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesores);

        cod=(EditText) findViewById(R.id.txtcodP);
        nom=(EditText) findViewById(R.id.txtnomP);
        cel=(EditText) findViewById(R.id.txtcelP);
        dir=(EditText) findViewById(R.id.txtdireP);
        email=(EditText) findViewById(R.id.txtcorP);
    }

    public void insertar(View v){
        dbmatricula gestion =new dbmatricula(this,"bdprofesores", null,1);
        SQLiteDatabase bd=gestion.getWritableDatabase();
        int codigo=Integer.parseInt(cod.getText()+"");
        String nombre=nom.getText().toString();
        int celular=Integer.parseInt(cel.getText()+"");
        String direccion=dir.getText().toString();
        String emai=email.getText().toString();

        ContentValues registro=new ContentValues();
        registro.put("cod_prof", codigo);
        registro.put("nom_prof", nombre);
        registro.put("telefono", celular);
        registro.put("dir_prof", direccion);
        registro.put("email", emai);

        bd.insert("profesores", null, registro);
        bd.close();
        cod.setText("");
        nom.setText("");
        cel.setText("");
        dir.setText("");
        email.setText("");

        Toast.makeText(this, "Se cargaron los datos", Toast.LENGTH_SHORT).show();
    }

    public void eliminar(View v){
        dbmatricula gestion=new dbmatricula(this,"bdprofesores", null,1);
        SQLiteDatabase bd=gestion.getWritableDatabase();
        String codigo=cod.getText().toString();
        int cant = bd.delete("profesores", "cod_prof=" + codigo, null);
        bd.close();
        cod.setText("");
        if(cant==1)
            Toast.makeText(this, "Se borraron los datos", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe el c�digo", Toast.LENGTH_SHORT).show();
    }

    public void consultadatos(View v){
        dbmatricula gestion=new dbmatricula(this,"bdprofesores", null,1);
        SQLiteDatabase bdatos=gestion.getWritableDatabase();
        String codigo=cod.getText().toString();
        Cursor fila=bdatos.rawQuery("select nom_prof,telefono,dir_prof,email from profesores where cod_prof=" + codigo, null);
        if(fila.moveToFirst()){
            nom.setText(fila.getString(0));
            cel.setText(fila.getString(1));
            dir.setText(fila.getString(2));
            email.setText(fila.getString(3));
        }
        else
            Toast.makeText(this, "No existe el c�digo", Toast.LENGTH_SHORT).show();
        bdatos.close();
    }

    public void actualizar(View v){
        dbmatricula gestion=new dbmatricula(this,"bdprofesores", null,1);
        SQLiteDatabase bd=gestion.getWritableDatabase();
        String codigo=cod.getText().toString();
        String nombre=nom.getText().toString();
        String celular=cel.getText().toString();
        String direccion=dir.getText().toString();
        String emai=email.getText().toString();

        ContentValues registro=new ContentValues();
        registro.put("nom_prof",nombre);
        registro.put("telefono",celular);
        registro.put("dir_prof",direccion);
        registro.put("email", emai);

        int cant=bd.update("profesores", registro, "cod_prof="+ codigo, null);
        if(cant==1)
            Toast.makeText(this, "Se modificaron los datos", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe el c�digo", Toast.LENGTH_SHORT).show();
    }
}
