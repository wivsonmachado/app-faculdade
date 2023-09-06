package com.example.ava1.utils;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ava1.R;
import com.example.ava1.dto.DisciplinaDTO;
import com.google.android.material.button.MaterialButton;

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

    public class MeuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
            TextView disciplina;
            TextView a1;
            TextView a2;
            TextView a3;
            TextView nfp;
            ImageButton menu;


        public MeuViewHolder(@NonNull View itemView) {
            super(itemView);
            disciplina = itemView.findViewById(R.id.nomeDisciplinaView);
            a1 = itemView.findViewById(R.id.a1View);
            a2 = itemView.findViewById(R.id.a2View);
            a3 = itemView.findViewById(R.id.a3View);
            nfp = itemView.findViewById(R.id.nfpView);
            menu = itemView.findViewById(R.id.button);
            menu.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            showMenu(view);
        }

        private void showMenu(View v){
            PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
            popupMenu.inflate(R.menu.menu_contexto);
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();

        }


        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if(item.getItemId() == R.id.menu_editar){
                Log.d("MyViewHolder", "OnMenuItemClick: menu_editar " + getAdapterPosition());
                return true;
            } else if (item.getItemId() == R.id.menu_excluir) {
                Log.d("MyViewHolder", "OnMenuItemClick: menu_excluir " + getAdapterPosition());
                return true;
            }else {
                return false;
            }
        }
    }


}
