package com.example.ava1.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ava1.R;
import com.example.ava1.controller.DisciplinaDAO;
import com.example.ava1.modelo.Disciplina;
import com.example.ava1.utils.DisciplinaAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListaDisciplinasActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DisciplinaDAO dao;
    private List<Disciplina> disciplinas;
    private List<Disciplina> disciplinasFiltradas = new ArrayList<>();
    private DisciplinaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_disciplinas);


        dao = new DisciplinaDAO(this);
        disciplinas = dao.getAllDisciplinas();
        adapter = new DisciplinaAdapter(disciplinas, dao);
        recyclerView = findViewById(R.id.listaDisciplinas);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    public void adicionarDiciplina(View view){
        Intent intent = new Intent(this, CadastroDisciplinaActivity.class);
        startActivity(intent);
        //finish();
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onPause() {
        super.onPause();
        finish();
    }

    @Override
    public void onRestart() {
        super.onRestart();
        //finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
    }




}