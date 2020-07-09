package ru.denfad.akva.models;

public class Plant {
    private String name;
    private String date;
    private int stay;
    private String deviants;

    public Plant(String name, String date, int stay, String deviants) {
        this.name = name;
        this.date = date;
        this.stay = stay;
        this.deviants = deviants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStay() {
        return stay;
    }

    public void setStay(int stay) {
        this.stay = stay;
    }

    public String getDeviants() {
        return deviants;
    }

    public void setDeviants(String deviants) {
        this.deviants = deviants;
    }
}
