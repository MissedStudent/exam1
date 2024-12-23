package com.example.para23_2;

public class Games {
        private int id; // id записи в таблице
        private String name; // полное имя автора, как будет отображаться в ComboBox
        private int year;
        private String dev;

        public Games(int id, String name,int year,String dev) {
            this.id = id;
            this.name = name;
            this.year=year;
            this.dev= dev;
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
        public  String getDev(){return dev;}
    }
