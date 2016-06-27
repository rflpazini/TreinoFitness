package com.rflpazini.treinofitness.physical;

public class PhysicalAval {

    private String peito;
    private String ombro;
    private String cintura;
    private String bracoDir;
    private String bracoEsq;
    private String anteDir;
    private String anteEsq;
    private String peso;
    private String alt;
    private String coxaDir;
    private String coxaEsp;

    public PhysicalAval() {

    }

    public PhysicalAval(String peito, String ombro, String cintura, String bracoDir, String bracoEsq,
                        String anteDir, String anteEsq, String peso, String alt, String coxaDir, String coxaEsp) {
        this.peito = peito;
        this.ombro = ombro;
        this.cintura = cintura;
        this.bracoDir = bracoDir;
        this.bracoEsq = bracoEsq;
        this.anteDir = anteDir;
        this.anteEsq = anteEsq;
        this.peso = peso;
        this.alt = alt;
        this.coxaDir = coxaDir;
        this.coxaEsp = coxaEsp;
    }

    public String getPeito() {
        return peito;
    }

    public void setPeito(String peito) {
        this.peito = peito;
    }

    public String getOmbro() {
        return ombro;
    }

    public void setOmbro(String ombro) {
        this.ombro = ombro;
    }

    public String getCintura() {
        return cintura;
    }

    public void setCintura(String cintura) {
        this.cintura = cintura;
    }

    public String getBracoDir() {
        return bracoDir;
    }

    public void setBracoDir(String bracoDir) {
        this.bracoDir = bracoDir;
    }

    public String getBracoEsq() {
        return bracoEsq;
    }

    public void setBracoEsq(String bracoEsq) {
        this.bracoEsq = bracoEsq;
    }

    public String getAnteDir() {
        return anteDir;
    }

    public void setAnteDir(String anteDir) {
        this.anteDir = anteDir;
    }

    public String getAnteEsq() {
        return anteEsq;
    }

    public void setAnteEsq(String anteEsq) {
        this.anteEsq = anteEsq;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getCoxaDir() {
        return coxaDir;
    }

    public void setCoxaDir(String coxaDir) {
        this.coxaDir = coxaDir;
    }

    public String getCoxaEsp() {
        return coxaEsp;
    }

    public void setCoxaEsp(String coxaEsp) {
        this.coxaEsp = coxaEsp;
    }
}
