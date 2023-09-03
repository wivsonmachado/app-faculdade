package com.example.ava1.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.ava1.conexao.Conexao;
import com.example.ava1.modelo.Disciplina;

public class DisciplinaDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public DisciplinaDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserirDisciplina(Disciplina disciplina){
        ContentValues values = new ContentValues();
        values.put("disciplina", disciplina.getNomeDiciplina());
        values.put("a1", disciplina.getA1());
        values.put("a2", disciplina.getA2());
        values.put("a3", disciplina.getA3());
        values.put("npf", disciplina.getNfp());

        return banco.insert("disciplina", null, values);
    }

}
