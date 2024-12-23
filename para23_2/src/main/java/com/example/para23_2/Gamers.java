package com.example.para23_2;

public class Gamers {
    private int id; // id записи в таблице
    private String nick; // полное имя автора, как будет отображаться в ComboBox
    private int year;
    private String game;

    public Gamers(int id, String nick,int year,String game) {
        this.id = id;
        this.nick = nick;
        this.year=year;
        this.game=game;
    }
    public Gamers(int id,String game){
        this.id=id;
        this.game=game;
    }

    // получение id из списка, необходимо для добавления новой записи в таблицу
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return nick; // Это то, что будет отображаться в ComboBox
    }
    public int getYear(){return year;}
    public  String getGame(){return game;}
}
