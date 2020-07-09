package ru.denfad.akva.models;

public class Fish {
    private String name;
    private String date;
    private int stay;
    private String about;

    public Fish(String name, String date, int stay, String about) {
        this.name = name;
        this.date = date;
        this.stay = stay;
        this.about = about;
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
