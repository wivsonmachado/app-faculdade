package com.example.ava1.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ava1.R;
import com.example.ava1.dto.DisciplinaDTO;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaAdapter extends RecyclerView.Adapter <DisciplinaAdapter.MeuViewHolder>{

    private List<DisciplinaDTO> disciplinas = new ArrayList<>();

    public DisciplinaAdapter(List<DisciplinaDTO> disciplinaList){
        this.disciplinas = disciplinaList;
    }

    @NonNull
    @Override
    public MeuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemDisciplina = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_disciplina, parent, false);
        return new MeuViewHolder(itemDisciplina);
    }

    @Override
    public void onBindViewHolder(@NonNull MeuViewHolder holder, int position) {

        DisciplinaDTO disciplina = disciplinas.get(position);

        holder.disciplina.setText(disciplina.getNomeDiciplina());
        holder.a1.setText(disciplina.getA1());
        holder.a2.setText(disciplina.getA2());
        holder.a3.setText(disciplina.getA3());
        holder.nfp.setText(disciplina.getNfp());

    }

    @Override
    public int getItemCount() {
        if(disciplinas == null || disciplinas.isEmpty()){
            return 0;
        }
        return disciplinas.size();
    }

    public class MeuViewHolder extends RecyclerView.ViewHolder{
            TextView disciplina;
            TextView a1;
            TextView a2;
            TextView a3;
            TextView nfp;


        public MeuViewHolder(@NonNull View itemView) {
            super(itemView);
            disciplina = itemView.findViewById(R.id.nomeDisciplinaView);
            a1 = itemView.findViewById(R.id.a1View);
            a2 = itemView.findViewById(R.id.a2View);
            a3 = itemView.findViewById(R.id.a3View);
            nfp = itemView.findViewById(R.id.nfpView);

        }
    }


}
