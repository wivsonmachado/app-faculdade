package com.example.ava1.modelo;

import java.io.Serializable;

public class Disciplina implements Serializable {

    private int id;
    private String nomeDiciplina;
    private double a1 = 0.0;
    private double a2 = 0.0;
    private double a3 = 0.0;
    private double nfp = 0.0;

    public Disciplina(){
    }
    public Disciplina(String nomeDiciplina, double a1, double a2, double a3, double nfp) {
        this.nomeDiciplina = nomeDiciplina;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.nfp = nfp;
    }

    public Disciplina(int id, String nomeDiciplina, double a1, double a2, double a3, double nfp) {
        this.id = id;
        this.nomeDiciplina = nomeDiciplina;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.nfp = nfp;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDiciplina() {
        return nomeDiciplina;
    }

    public void setNomeDiciplina(String nomeDiciplina) {
        this.nomeDiciplina = nomeDiciplina;
    }

    public double getA1() {
        return a1;
    }

    public void setA1(double a1) {
        this.a1 = a1;
    }

    public double getA2() {
        return a2;
    }

    public void setA2(double a2) {
        this.a2 = a2;
    }

    public double getA3() {
        return a3;
    }

    public void setA3(double a3) {
        this.a3 = a3;
    }

    public double getNfp() {
        return nfp;
    }
    public void setNfp(double nfp) {
        this.nfp = nfp;
    }

    @Override
    public String toString() {
        return "Diciplina=" + nomeDiciplina +
                ", A1=" + a1 +
                ", A2=" + a2 +
                ", A3=" + a3 +
                ", NFp= " + nfp;
    }

}
