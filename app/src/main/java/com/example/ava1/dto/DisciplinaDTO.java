package com.example.ava1.dto;

public class DisciplinaDTO{
    private String nomeDiciplina;
    private String a1;
    private String a2;
    private String a3;
    private String nfp;

    public DisciplinaDTO(String nomeDiciplina, String a1, String a2, String a3, String nfp) {
        this.nomeDiciplina = nomeDiciplina;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.nfp = nfp;
    }

    public String getNomeDiciplina() {
        return nomeDiciplina;
    }

    public void setNomeDiciplina(String nomeDiciplina) {
        this.nomeDiciplina = nomeDiciplina;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public String getNfp() {
        return nfp;
    }

    public void setNfp(String nfp) {
        this.nfp = nfp;
    }
}
