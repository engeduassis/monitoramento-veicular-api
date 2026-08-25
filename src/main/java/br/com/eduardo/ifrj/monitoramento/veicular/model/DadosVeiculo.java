package br.com.eduardo.ifrj.monitoramento.veicular.model;

public class DadosVeiculo {

    private double rpm;
    private double velocidade;
    private double temperaturaMotor;
    private double pressaoMap;
    private double maf;

    public double getRpm() {
        return rpm;
    }

    public void setRpm(double rpm) {
        this.rpm = rpm;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public double getTemperaturaMotor() {
        return temperaturaMotor;
    }

    public void setTemperaturaMotor(double temperaturaMotor) {
        this.temperaturaMotor = temperaturaMotor;
    }

    public double getPressaoMap() {
        return pressaoMap;
    }

    public void setPressaoMap(double pressaoMap) {
        this.pressaoMap = pressaoMap;
    }

    public double getMaf() {
        return maf;
    }

    public void setMaf(double maf) {
        this.maf = maf;
    }
}