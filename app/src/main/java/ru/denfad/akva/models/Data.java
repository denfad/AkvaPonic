package ru.denfad.akva.models;

public class Data {
    private double ph;
    private int temperature;

    public Data(double ph, int temperature) {
        this.ph = ph;
        this.temperature = temperature;
    }

    public Data() {
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
