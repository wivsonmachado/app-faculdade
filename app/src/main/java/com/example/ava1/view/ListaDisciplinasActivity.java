package com.example.ava1.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ava1.R;
import com.example.ava1.controller.DisciplinaDAO;
import com.example.ava1.modelo.Disciplina;
import com.example.ava1.utils.DisciplinaAdapter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ListaDisciplinasActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DisciplinaDAO dao;
    private List<Disciplina> disciplinas;
    private List<Disciplina> disciplinasFiltradas = new ArrayList<>();
    private DisciplinaAdapter adapter;
    private TextView cr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_disciplinas);

        cr = findViewById(R.id.idCr);

        dao = new DisciplinaDAO(this);
        disciplinas = dao.getAllDisciplinas();
        adapter = new DisciplinaAdapter(disciplinas, dao);
        recyclerView = findViewById(R.id.listaDisciplinas);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        double cr1 = calculaCr();
        String crFormatado = arredondarResultado(cr1);
        cr.setText(crFormatado);
    }

    public void adicionarDiciplina(View view){
        Intent intent = new Intent(this, CadastroDisciplinaActivity.class);
        startActivity(intent);
        //finish();
    }

    public Double calculaCr(){
        Double npfGeral = 0.0;
        Double cr = 0.0;
        List<Disciplina> disciplinas = dao.getAllDisciplinas();
        for(Disciplina disciplina: disciplinas){
            npfGeral = npfGeral + disciplina.getNfp();
        }
        cr = npfGeral / disciplinas.size();
        return cr;
    }

    private String arredondarResultado(double resultado){
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(resultado);
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