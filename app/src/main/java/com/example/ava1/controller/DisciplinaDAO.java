package com.example.ava1.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;

import com.example.ava1.conexao.Conexao;
import com.example.ava1.modelo.Disciplina;

import java.util.ArrayList;
import java.util.List;

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
        long id = banco.insert("disciplina", null, values);
        return id;
    }

    public List<Disciplina> getAllDisciplinas(){
        List<Disciplina> disciplinas = new ArrayList<>();
        Cursor cursor = banco.query("disciplina", new String[]{"id", "disciplina", "a1", "a2", "a3", "npf"}, null, null, null, null, null);
        while (cursor.moveToNext()){
            Disciplina disciplina = new Disciplina(cursor.getInt(0)
                    ,cursor.getString(1)
                    ,cursor.getDouble(2)
                    ,cursor.getDouble(3)
                    ,cursor.getDouble(4)
                    ,cursor.getDouble(5));
            disciplinas.add(disciplina);
        }
        return disciplinas;
    }

    public void delete(@NonNull Disciplina disciplina){
        banco.delete("disciplina", "id = ?", new String[]{String.valueOf(disciplina.getId())});
    }

    public long atualizarDisciplina(Disciplina disciplina) {
        ContentValues values = new ContentValues();
        values.put("disciplina", disciplina.getNomeDiciplina());
        values.put("a1", disciplina.getA1());
        values.put("a2", disciplina.getA2());
        values.put("a3", disciplina.getA3());
        values.put("npf", disciplina.getNfp());
        long id = banco.update("disciplina", values, "id = ?", new String[]{String.valueOf(disciplina.getId())});
        return id;
    }
}
