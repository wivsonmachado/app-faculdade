package com.example.ava1;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ava1.modelo.Disciplina;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText nomeDisciplina;
    private EditText notaA1;
    private EditText notaA2;
    private EditText notaA3;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeDisciplina = (EditText) findViewById(R.id.nomeDisciplina);
        notaA1 = (EditText) findViewById(R.id.notaA1);
        notaA1.setFilters(new InputFilter[]{new MinMaxFilter(0.0, 10.0)});
        notaA2 = (EditText) findViewById(R.id.notaA2);
        notaA2.setFilters(new InputFilter[]{new MinMaxFilter(0.0, 10.0)});
        notaA3 = (EditText) findViewById(R.id.notaA3);
        notaA3.setFilters(new InputFilter[]{new MinMaxFilter(0.0, 10.0)});
        btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<EditText> campos = new ArrayList<>(Arrays.asList(nomeDisciplina, notaA1, notaA2, notaA3));
                AlertDialog alert;
                Map<String, Boolean> checkCampos = campoVazio(campos);
                if(!checkCampos.isEmpty()){
                    alert = mensagem("Campos Vazios", "É necessário informar: "
                             + checkCampos.keySet().stream().findFirst().get(), null);
                    alert.show();
                }else {
                    String disciplinaNome = nomeDisciplina.getText().toString();
                    Double a1 = Double.valueOf(notaA1.getText().toString());
                    Double a2 = Double.valueOf(notaA2.getText().toString());
                    Double a3 = Double.valueOf(notaA3.getText().toString());
                    Disciplina disciplina = new Disciplina(disciplinaNome, a1, a2, a3);
                    Toast.makeText(MainActivity.this, disciplina.toString(), Toast.LENGTH_SHORT).show();
                    try {
                        InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }

                }
            }
        });

    }

    private Map<String, Boolean> campoVazio(List<EditText> campos){
        Map<String, Boolean> validaCampos = new HashMap<>();
        for(EditText campo: campos){
            if(campo.getText().toString().matches("")){
                validaCampos.put((String) campo.getHint(), true);
            }
        }
        return validaCampos;
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

