package com.example.semana72;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class dbmatricula extends SQLiteOpenHelper {

	public dbmatricula(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	public void onCreate(SQLiteDatabase db){

		db.execSQL("create table alumno(cod_alu integer primary key, nom_alu text, dir_alu text, correo text, celular integer)");
		db.execSQL("create table carrera(cod_carrera integer primary key, carrera text)");
		db.execSQL("create table profesores(cod_prof integer primary key, nom_prof text, telefono integer, dir_prof text,email text)");
		db.execSQL("create table cursos(cod_cursos integer primary key,nom_curso text)");

	}

	public void onUpgrade(SQLiteDatabase db, int VerAnt, int VerNew){
		db.execSQL("drop table if exists alumno");
		db.execSQL("drop table if exists carrera");
		db.execSQL("drop table if exists profesores");
		db.execSQL("drop table if exists cursos");
		db.execSQL("create table alumno(cod_alu integer primary key, nom_alu text, dir_alu text, correo text, celular integer)");
		db.execSQL("create table carrera(cod_carrera integer primary key, carrera text)");
		db.execSQL("create table profesores(cod_prof integer primary key, nom_prof text,  telefono integer, dir_prof text,email text)");
		db.execSQL("create table cursos(cod_cursos integer primary key,nom_curso text)");
	}
}