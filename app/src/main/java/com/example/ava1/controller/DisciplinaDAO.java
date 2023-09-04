package com.example.ava1.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.biometrics.BiometricManager;

import com.example.ava1.conexao.Conexao;
import com.example.ava1.dto.DisciplinaDTO;
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

        return banco.insert("disciplina", null, values);
    }

    public List<DisciplinaDTO> getAllDisciplinas(){
        List<DisciplinaDTO> disciplinas = new ArrayList<>();
        Cursor cursor = banco.query("disciplina", new String[]{"disciplina", "a1", "a2", "a3", "npf"}, null, null, null, null, null);
        while (cursor.moveToNext()){
            DisciplinaDTO disciplina = new DisciplinaDTO(cursor.getString(0)
            ,String.valueOf(cursor.getDouble(1))
            ,String.valueOf(cursor.getDouble(2))
            ,String.valueOf(cursor.getDouble(3))
            ,String.valueOf(cursor.getDouble(4)));
            disciplinas.add(disciplina);
        }
        return disciplinas;
    }

}
