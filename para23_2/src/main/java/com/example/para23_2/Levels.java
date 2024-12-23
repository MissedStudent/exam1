package com.example.para23_2;

public class Levels {
    private int id; // id записи в таблице
    private String name; // полное имя автора, как будет отображаться в ComboBox
    private String game;

    public Levels(int id, String name,String game) {
        this.id = id;
        this.name = name;
        this.game=game;
    }

    // получение id из списка, необходимо для добавления новой записи в таблицу
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name; // Это то, что будет отображаться в ComboBox
    }
    public  String getGame(){return game;}
}
