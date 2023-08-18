package be.technifutur.springdemo.entity;

public enum Plateform {
    PC("PC"),
    PLAYSTATION("PlayStation"),
    XBOX("Xbox"),
    NINTENDO("Nintendo"),
    AUTRE("Autre");

    private final String name;

    private Plateform(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }}
