package com.example.mvaguimaraes.rotatingwheel;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BD {
    private SQLiteDatabase bd;

    public BD(Context context){
        BDCore auxBd = new BDCore(context);
        bd = auxBd.getWritableDatabase();
    }


    public void inserir(Usuario usuario){
        ContentValues valores = new ContentValues();
        valores.put("nome", usuario.getNome());
        valores.put("email", usuario.getEmail());
        valores.put("password", usuario.getPassword());

        bd.insert("usuario", null, valores);
    }


    public void atualizar(Usuario usuario){
        ContentValues valores = new ContentValues();
        valores.put("nome", usuario.getNome());
        valores.put("email", usuario.getEmail());
        valores.put("password", usuario.getPassword());

        bd.update("usuario", valores, "_id = ?", new String[]{""+usuario.getId()});
    }


    public void deletar(Usuario usuario){
        bd.delete("usuario", "_id = "+usuario.getId(), null);
    }


    public Usuario buscar(String email){
		String[] colunas = new String[]{"_id", "nome", "email","password"};

		Usuario usuario = new Usuario();
        Cursor cursor = bd.query("usuario", colunas, "email" + " = '" + email + "'", null, null, null, null);


		if(cursor.getCount() > 0){
			cursor.moveToFirst();

			do{

				Usuario u = new Usuario();
				u.setId(cursor.getLong(0));
                u.setNome(cursor.getString(1));
                u.setEmail(cursor.getString(2));
                u.setPassword(cursor.getString(3));

            }while(cursor.moveToNext());
		}

		return(usuario);
	}
}
