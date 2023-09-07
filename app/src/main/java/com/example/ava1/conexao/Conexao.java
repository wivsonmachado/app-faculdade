package com.example.ava1.conexao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    private static final String NAME = "ava2.app";
    private static final int VERSION = 1;
    public Conexao(@Nullable Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table disciplina(id integer primary key autoincrement" +
                ", disciplina varchar(244) not null" +
                ", a1 decimal(2,2) not null" +
                ", a2 decimal(2,2) not null" +
                ", a3 decimal(2,2) not null" +
                ", npf decimal(2,2) not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
