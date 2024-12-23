package com.example.para23_2;

public class Dev {
    private int id; // id записи в таблице
    private String name; // полное имя автора, как будет отображаться в ComboBox
    private int year;

    public Dev(int id, String name,int year) {
        this.id = id;
        this.name = name;
        this.year=year;
    }

    // получение id из списка, необходимо для добавления новой записи в таблицу
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name; // Это то, что будет отображаться в ComboBox
    }
    public int getYear(){return year;}
}
