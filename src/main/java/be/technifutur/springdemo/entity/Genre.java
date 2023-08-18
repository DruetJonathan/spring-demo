package be.technifutur.springdemo.entity;

public enum Genre {
    ACTION("Action"),
    AVENTURE("Aventure"),
    RPG("RPG"),
    SPORT("Sport"),
    AUTRE("Autre");

    private final String name;

    private Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }}
