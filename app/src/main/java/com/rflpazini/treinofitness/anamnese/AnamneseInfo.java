package com.rflpazini.treinofitness.anamnese;

public class AnamneseInfo {
    private String hipertensao;
    private String diabete;
    private String articulacao;
    private String fuma;
    private String estresse;
    private String cardiaco;
    private String muscular;

    public AnamneseInfo() {
    }

    public AnamneseInfo(String hipertensao, String diabete, String articulacao, String fuma,
                        String estresse, String cardiaco, String muscular) {
        this.hipertensao = hipertensao;
        this.diabete = diabete;
        this.articulacao = articulacao;
        this.fuma = fuma;
        this.estresse = estresse;
        this.cardiaco = cardiaco;
        this.muscular = muscular;
    }

    public String getHipertensao() {
        return hipertensao;
    }

    public void setHipertensao(String hipertensao) {
        this.hipertensao = hipertensao;
    }

    public String getDiabete() {
        return diabete;
    }

    public void setDiabete(String diabete) {
        this.diabete = diabete;
    }

    public String getArticulacao() {
        return articulacao;
    }

    public void setArticulacao(String articulacao) {
        this.articulacao = articulacao;
    }

    public String getFuma() {
        return fuma;
    }

    public void setFuma(String fuma) {
        this.fuma = fuma;
    }

    public String getEstresse() {
        return estresse;
    }

    public void setEstresse(String estresse) {
        this.estresse = estresse;
    }

    public String getCardiaco() {
        return cardiaco;
    }

    public void setCardiaco(String cardiaco) {
        this.cardiaco = cardiaco;
    }

    public String getMuscular() {
        return muscular;
    }

    public void setMuscular(String muscular) {
        this.muscular = muscular;
    }
}
