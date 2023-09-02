package com.example.ava1;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;

import android.text.InputFilter;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import android.widget.EditText;

import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText notaA1;
    private EditText notaA2;
    private EditText notaA3;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notaA1 = (EditText) findViewById(R.id.notaA1);
        notaA1.setFilters(new InputFilter[]{new MinMaxFilter(0.0, 10.0)});
        notaA2 = (EditText) findViewById(R.id.notaA2);
        notaA2.setFilters(new InputFilter[]{new MinMaxFilter(0.0, 10.0)});
        notaA3 = (EditText) findViewById(R.id.notaA3);
        notaA3.setFilters(new InputFilter[]{new MinMaxFilter(0.0, 10.0)});
        btnCalcular = (Button) findViewById(R.id.btnCalc);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<EditText> campos = new ArrayList<>(Arrays.asList(notaA1, notaA2, notaA3));
                AlertDialog alert;
                if(campoVazio(campos)){
                    alert = mensagem("Campos Vazios", "É necessário informar todas as notas", null);
                    alert.show();
                }else {
                    Double a1 = Double.valueOf(notaA1.getText().toString());
                    Double a2 = Double.valueOf(notaA2.getText().toString());
                    Double a3 = Double.valueOf(notaA3.getText().toString());
                    String media = calculoMedia(a1, a2, a3);
                    alert = mensagem("NFp", "Sua NFp é ", media);
                    alert.show();
                    try {
                        InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    notaA1.setText("");
                    notaA2.setText("");
                    notaA3.setText("");
                    notaA1.requestFocus();
                }
            }
        });

    }

    private boolean campoVazio(List<EditText> campos){
        for(EditText campo: campos){
            if(campo.getText().toString().matches("")){
                return true;
            }
        }
        return false;
    }

    private AlertDialog mensagem(String title, String msg, String complementoMsg){
        AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
        mensagem.setTitle(title);
        if(complementoMsg != null){
            mensagem.setMessage(msg + complementoMsg);
        }else{
            mensagem.setMessage(msg);
        }
        mensagem.setNeutralButton("Ok", null);
        return mensagem.create();
    }

    private String arredondarResultado(double resultado){
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(resultado);
    }

    private String calculoMedia(Double a1, Double a2, Double a3){
        Double nota1 = a1;
        Double nota2 = a2;
        if(a2 < a3){
            nota2 = a3;
        }
        Double resultado = (nota1 * 0.4) + (nota2 * 0.6);
        if(nota1 == 0.0 || nota2 < 5.0){
            resultado = (nota1 * 0.4) + (nota2 * 0.6)/2;
        }
        return arredondarResultado(resultado);
    }
}

