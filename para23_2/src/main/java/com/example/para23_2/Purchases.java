package com.example.para23_2;

public class Purchases {
    private int id; // id записи в таблице
    private String code; // полное имя автора, как будет отображаться в ComboBox
    private String gamer;
    private String game;

    public Purchases(int id, String code,String gamer,String game) {
        this.id = id;
        this.code = code;
        this.gamer=gamer;
        this.game=game;
    }

    // получение id из списка, необходимо для добавления новой записи в таблицу
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return code; // Это то, что будет отображаться в ComboBox
    }
    public  String getGame(){return game;}
    public String getGamer(){return gamer;}
}
