package com.example.para23_2;

public class Reviews {
    private int id; // id записи в таблице
    private String text; // полное имя автора, как будет отображаться в ComboBox
    private String game;

    public Reviews(int id, String text,String game) {
        this.id = id;
        this.text = text;
        this.game=game;
    }

    // получение id из списка, необходимо для добавления новой записи в таблицу
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return text; // Это то, что будет отображаться в ComboBox
    }
    public  String getGame(){return game;}
}
