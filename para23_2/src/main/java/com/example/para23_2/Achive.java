package com.example.para23_2;

public class Achive {
    private int id; // id записи в таблице
    private String name; // полное имя автора, как будет отображаться в ComboBox
    private String gamer;
    private String game;

    public Achive(int id, String name,String gamer,String game) {
        this.id = id;
        this.name = name;
        this.gamer=gamer;
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
    public String getGamer(){return gamer;}
    public  String getGame(){return game;}
}
