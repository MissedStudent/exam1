package com.example.para23_2;

public class Tournament {
    private int id; // id записи в таблице
    private String name; // полное имя автора, как будет отображаться в ComboBox
    private String location;
    private int prize;
    private String game;

    public Tournament(int id, String name,String location,int prize,String game) {
        this.id = id;
        this.name = name;
        this.location=location;
        this.prize=prize;
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
    public String getLocation(){return location;}
    public int getPrize(){return prize;}
}
