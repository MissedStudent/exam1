package com.example.para23_2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    public TextArea look_gamer;
    public Button looking_gamer_button;
    
    public TextArea look_game;
    public Button looking_game_button;
    
    public TextArea look_achiv;
    public Button looking_achiv_button;
    
    public TextArea look_level;
    public Button looking_level_button;
    
    public TextArea look_dev;
    public Button looking_dev_button;
    
    public TextArea look_review;
    public Button looking_review_button;
    
    public TextArea look_purchase;
    public Button looking_purchase_button;
    
    public TextArea look_sub;
    public Button looking_sud_button;
    
    public TextArea look_mod;
    public Button looking_mod_button;
    
    public TextArea look_tour;
    public Button looking_tournament_button;
    
    public TextField add_gamer_nick;
    public TextField add_gamer_year;
    public ComboBox add_gamer_game;
    public ComboBox add_gamer_purchase;
    public ComboBox add_gamer_sub;
    public Button add_gamer_initialize;
    public Button add_gamer;
    
    public TextField add_game_name;
    public TextField add_game_year;
    public ComboBox add_game_dev;
    public Button add_game_initialize;
    public Button add_game;
    
    public TextField add_achiv_name;
    public ComboBox add_achiv_game;
    public ComboBox add_achiv_gamer;
    public Button add_achiv_initialize;
    public Button add_achiv;

    public TextField add_level_name;
    public ComboBox add_level_game;
    public Button add_level_initialize;
    public Button add_level;

    public TextField add_dev_name;
    public TextField add_dev_year;
    public Button add_dev;

    public TextField add_review_text;
    public ComboBox add_review_game;
    public Button add_review_initialize;
    public Button add_review;

    public TextField add_purchase_code;
    public ComboBox add_purchase_gamer;
    public ComboBox add_purchase_game;
    public Button add_purchase_initialize;
    public Button add_purchase;

    public TextField add_sub_code;
    public ComboBox add_sub_gamer;
    public ComboBox add_sub_game;
    public Button add_sub_initialize;
    public Button add_sub;

    public TextField add_mod_name;
    public ComboBox add_mod_game;
    public Button add_mod_initialize;
    public Button add_mod;

    public TextField add_tour_name;
    public TextField add_tour_location;
    public TextField add_tour_prize;
    public ComboBox add_tour_game;
    public Button add_tour_initialize;
    public Button add_tour;

    public TextField redo_game_name_original;
    public TextField redo_game_name;
    public TextField redo_game_year;
    public ComboBox redo_game_dev;
    public Button redo_game_initialize;
    public Button redo_game;

    public TextField redo_achievement_name_original;
    public TextField redo_achiv_name;
    public ComboBox redo_achiv_game;
    public ComboBox redo_achiv_gamer;
    public Button redo_achiv_initialize;
    public Button redo_achiv;

    public TextField redo_level_name_original;
    public TextField redo_level_name;
    public ComboBox redo_level_game;
    public Button redo_level_initialize;
    public Button redo_level;

    public TextField redo_dev_name_original;
    public TextField redo_dev_name;
    public TextField redo_dev_year;
    public Button redo_dev;

    public TextField redo_purchase_code_original;
    public TextField redo_purchase_code;
    public ComboBox redo_purchase_gamer;
    public ComboBox redo_purchase_game;
    public Button redo_purchase_initialize;
    public Button redo_purchase;

    public TextField redo_sub_code_original;
    public TextField redo_sub_code;
    public ComboBox redo_sub_gamer;
    public ComboBox redo_sub_game;
    public Button redo_sub_initialize;
    public Button redo_sub;

    public TextField redo_mod_name_original;
    public TextField redo_mod_name;
    public ComboBox redo_mod_game;
    public Button redo_mod_initialize;
    public Button redo_mod;

    public TextField redo_tour_name_original;
    public TextField redo_tour_name;
    public TextField redo_tour_location;
    public TextField redo_tour_prize;
    public ComboBox redo_tour_game;
    public Button redo_tour_initialize;
    public Button redo_tour;

    public TextField delete_gamer_nick;
    public Button delete_gamer;

    public TextField delete_game_name;
    public Button delete_game;

    public TextField delete_achievement_name;
    public Button delete_achievement;
    
    public TextField delete_level_name;
    public Button delete_level;
    
    public TextField delete_dev_name;
    public Button delete_dev;
    
    public TextField delete_purchase_code;
    public Button delete_purchase;
    
    public TextField delete_sub_code;
    public Button delete_sub;
    
    public TextField delete_mod_name;
    public Button delete_mod;
    public TextField delete_tour_name;
    public Button delete_tour;

    BD bd=new BD();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        stage.setTitle("Да как тебя программировать");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
    public void look_for_gamers(ActionEvent actionEvent) {
        List<Gamers> gamers=bd.selectGamer();
        int i=0;
        while (gamers.size()>i){
            look_gamer.appendText(gamers.get(i).toString());
            look_gamer.appendText("   ");
            look_gamer.appendText(String.valueOf(gamers.get(i).getYear()));
            look_gamer.appendText("   ");
            look_gamer.appendText(gamers.get(i).getGame());
            look_gamer.appendText("\n");
            i++;
        }
    }
    public void look_for_games(ActionEvent actionEvent) {
        List<Games> games=bd.selectGame();
        int i=0;
        while (games.size()>i){
            look_game.appendText(games.get(i).toString());
            look_game.appendText("   ");
            look_game.appendText(String.valueOf(games.get(i).getYear()));
            look_game.appendText("   ");
            look_game.appendText(games.get(i).getDev());
            look_game.appendText("\n");
            i++;
        }
    }
    public void look_for_achiv(ActionEvent actionEvent) {//
        List<Achive> achives=bd.selectAchive();
        int i=0;
        while (achives.size()>i){
            look_achiv.appendText(achives.get(i).toString());
            look_achiv.appendText("   ");
            look_achiv.appendText(achives.get(i).getGame());
            look_achiv.appendText("   ");
            look_achiv.appendText(achives.get(i).getGamer());
            look_achiv.appendText("\n");
            i++;
        }
    }
    public void look_for_levels(ActionEvent actionEvent) {
        List<Levels> levels=bd.selectLevel();
        int i=0;
        while (levels.size()>i){
            look_level.appendText(levels.get(i).toString());
            look_level.appendText("   ");
            look_level.appendText(levels.get(i).getGame());
            look_level.appendText("\n");
            i++;
        }
    }
    public void look_for_devs(ActionEvent actionEvent) {//
        List<Dev> devs =bd.selectDev();
        int i=0;
        while (devs.size()>i){
            look_dev.appendText(devs.get(i).toString());
            look_dev.appendText("   ");
            look_dev.appendText(String.valueOf(devs.get(i).getYear()));
            look_dev.appendText("\n");
            i++;
        }
    }
    public void look_for_reviews(ActionEvent actionEvent) {
        List<Reviews> reviews =bd.selectReview();
        int i=0;
        while (reviews.size()>i){
            look_review.appendText(reviews.get(i).toString());
            look_review.appendText("   ");
            look_review.appendText(reviews.get(i).getGame());
            look_review.appendText("\n");
            i++;
        }
    }
    public void look_for_purchases(ActionEvent actionEvent) {
        List<Purchases> purchases =bd.selectPurchase();
        int i=0;
        while (purchases.size()>i){
            look_purchase.appendText(purchases.get(i).toString());
            look_purchase.appendText("   ");
            look_purchase.appendText(purchases.get(i).getGamer());
            look_purchase.appendText("   ");
            look_purchase.appendText(purchases.get(i).getGame());
            look_purchase.appendText("\n");
            i++;
        }
    }
    public void look_for_subs(ActionEvent actionEvent) {
        List<Subs> subs =bd.selectSub();
        int i=0;
        while (subs.size()>i){
            look_sub.appendText(subs.get(i).toString());
            look_sub.appendText("   ");
            look_sub.appendText(subs.get(i).getGamer());
            look_sub.appendText("   ");
            look_sub.appendText(subs.get(i).getGame());
            look_sub.appendText("\n");
            i++;
        }
    }
    public void look_for_mods(ActionEvent actionEvent) {
        List<Mods> mods =bd.selectMod();
        int i=0;
        while (mods.size()>i){
            look_mod.appendText(mods.get(i).toString());
            look_mod.appendText("   ");
            look_mod.appendText(mods.get(i).getGame());
            look_mod.appendText("\n");
            i++;
        }
    }
    public void look_for_tournaments(ActionEvent actionEvent) {
        List<Tournament> tournaments=bd.selectTournament();
        int i=0;
        while (tournaments.size()>i){
            look_tour.appendText(tournaments.get(i).toString());
            look_tour.appendText("   ");
            look_tour.appendText(tournaments.get(i).getLocation());
            look_tour.appendText("   ");
            look_tour.appendText(String.valueOf(tournaments.get(i).getPrize()));
            look_tour.appendText("   ");
            look_tour.appendText(tournaments.get(i).getGame());
            look_tour.appendText("\n");
            i++;
        }
    }
//-------------------------------------------------------------------------------------------------------------------
    public void initialize_gamer(ActionEvent actionEvent) {
        add_gamer_game.getItems().addAll(bd.selectGame());
        add_gamer_initialize.setDisable(true);
    }

    public void plus_gamer(ActionEvent actionEvent) {
        String gamer_name = add_gamer_nick.getText();
        int gamer_year= Integer.parseInt(add_gamer_year.getText());
        Games gamer_game =(Games)add_gamer_game.getValue();
        if (gamer_name.isEmpty()||gamer_year==0|| gamer_game ==null)
        {
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else bd.addGamer(gamer_name,gamer_year, gamer_game.getId());
    }

    public void initialize_game(ActionEvent actionEvent) {
        add_game_dev.getItems().addAll(bd.selectDev());
        redo_game_dev.getItems().addAll(bd.selectDev());
        add_game_initialize.setDisable(true);
        redo_game_initialize.setDisable(true);
    }

    public void plus_game(ActionEvent actionEvent) {
        String game_name = add_game_name.getText();
        int game_year= Integer.parseInt(add_game_year.getText());
        Dev game_dev =(Dev)add_game_dev.getValue();
        if (game_name.isEmpty()||game_year==0|| game_dev ==null)
        {
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (bd.selectGame().contains(game_name)) {
            JOptionPane.showMessageDialog(null, "Такая игра уже есть", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else bd.addGame(game_name,game_year, game_dev.getId());
    }

    public void initialize_achiv(ActionEvent actionEvent) {
        add_achiv_game.getItems().addAll(bd.selectGame());
        add_achiv_gamer.getItems().addAll(bd.selectGamer());
        redo_achiv_game.getItems().addAll(bd.selectGame());
        redo_achiv_gamer.getItems().addAll(bd.selectGamer());
        add_achiv_initialize.setDisable(true);
        redo_achiv_initialize.setDisable(true);
    }

    public void plus_achiv(ActionEvent actionEvent) {
        String achievement_name = add_achiv_name.getText();
        Games achievement_game= (Games)add_achiv_game.getValue();
        Gamers achievement_gamer =(Gamers)add_achiv_gamer.getValue();
        if (achievement_name.isEmpty()||achievement_game==null|| achievement_gamer ==null)
        {
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (bd.selectAchive().contains(achievement_name)) {
            JOptionPane.showMessageDialog(null, "Такое достижение уже есть", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else bd.addAchievement(achievement_name,achievement_game.getId(), achievement_gamer.getId());
    }

    public void initialize_level(ActionEvent actionEvent) {
        add_level_game.getItems().addAll(bd.selectGame());
        redo_level_game.getItems().addAll(bd.selectGame());
        add_level_initialize.setDisable(true);
        redo_level_initialize.setDisable(true);
    }

    public void plus_level(ActionEvent actionEvent) {
        String level_name = add_level_name.getText();
        Games achievement_game= (Games)add_level_game.getValue();
        if (level_name.isEmpty()||achievement_game==null)
        {
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (bd.selectLevel().contains(level_name)) {
            JOptionPane.showMessageDialog(null, "Такой уровень уже есть", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else bd.addLevel(level_name,achievement_game.getId());
    }

    public void plus_dev(ActionEvent actionEvent) {
        String dev_name = add_dev_name.getText();
        int dev_year = Integer.parseInt(add_dev_year.getText());
        if (dev_name.isEmpty()||dev_year==0)
        {
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (bd.selectDev().contains(dev_name)) {
            JOptionPane.showMessageDialog(null, "Такой уровень уже есть", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else bd.addDev(dev_name,dev_year);
    }

    public void initialize_review(ActionEvent actionEvent) {
        add_review_game.getItems().addAll(bd.selectGame());
        add_review_initialize.setDisable(true);
    }

    public void plus_review(ActionEvent actionEvent) {
        String level_name = add_review_text.getText();
        Games review_game = (Games)add_review_game.getValue();
        if (level_name.isEmpty()|| review_game ==null)
        {
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else bd.addReview(level_name, review_game.getId());
    }

    public void initialize_purchase(ActionEvent actionEvent) {
        add_purchase_game.getItems().addAll(bd.selectGame());
        add_purchase_gamer.getItems().addAll(bd.selectGamer());
        redo_purchase_game.getItems().addAll(bd.selectGame());
        redo_purchase_gamer.getItems().addAll(bd.selectGamer());
        add_purchase_initialize.setDisable(true);
        redo_purchase_initialize.setDisable(true);
    }

    public void plus_purchase(ActionEvent actionEvent) {
        String code = add_purchase_code.getText();
        Games purchase_game = (Games)add_purchase_game.getValue();
        Gamers purchase_gamer=(Gamers)add_purchase_gamer.getValue();
        if (code.isEmpty()|| purchase_game ==null||purchase_gamer==null)
        {
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (bd.selectPurchase().contains(code)) {
            JOptionPane.showMessageDialog(null, "Такая покупка уже есть", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else bd.addPurchase(code, purchase_game.getId(),purchase_gamer.getId());
    }

    public void initialize_sub(ActionEvent actionEvent) {
        add_sub_game.getItems().addAll(bd.selectGame());
        add_sub_gamer.getItems().addAll(bd.selectGamer());
        redo_sub_game.getItems().addAll(bd.selectGame());
        redo_sub_gamer.getItems().addAll(bd.selectGamer());
        add_sub_initialize.setDisable(true);
        redo_sub_initialize.setDisable(true);
    }

    public void plus_sub(ActionEvent actionEvent) {
        String code = add_sub_code.getText();
        Games sub_game = (Games)add_sub_game.getValue();
        Gamers sub_gamer =(Gamers)add_sub_gamer.getValue();
        if (code.isEmpty()|| sub_game ==null|| sub_gamer ==null)
        {
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (bd.selectSub().contains(code)) {
            JOptionPane.showMessageDialog(null, "Такая подписка уже есть", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else bd.addSub(code, sub_game.getId(), sub_gamer.getId());
    }

    public void initialize_mod(ActionEvent actionEvent) {
        add_mod_game.getItems().addAll(bd.selectGame());
        redo_mod_game.getItems().addAll(bd.selectGame());
        add_mod_initialize.setDisable(true);
        redo_mod_initialize.setDisable(true);
    }

    public void plus_mod(ActionEvent actionEvent) {
        String mod_name = add_mod_name.getText();
        Games sub_game = (Games)add_mod_game.getValue();
        if (mod_name.isEmpty()|| sub_game ==null)
        {
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (bd.selectMod().contains(mod_name)) {
            JOptionPane.showMessageDialog(null, "Такой мод уже есть", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else bd.addMod(mod_name, sub_game.getId());
    }

    public void initialize_tour(ActionEvent actionEvent) {
        add_tour_game.getItems().addAll(bd.selectGame());
        redo_tour_game.getItems().addAll(bd.selectGame());
        add_tour_initialize.setDisable(true);
        redo_tour_initialize.setDisable(true);
    }

    public void plus_tour(ActionEvent actionEvent) {
        String tour_name = add_tour_name.getText();
        String tour_location = add_tour_location.getText();
        int prize = Integer.parseInt(add_tour_prize.getText());
        Games tour_game = (Games)add_tour_game.getValue();
        if (tour_name.isEmpty()|| tour_game ==null||tour_location.isEmpty()||prize==0)
        {
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (bd.selectTournament().contains(tour_name)) {
            JOptionPane.showMessageDialog(null, "Такой турнир уже есть", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else bd.addTour(tour_name, tour_location,prize,tour_game.getId());
    }
    //---------------------------------------------------------------
    //UPDATE `subscriptions` SET subscriptions.game_id='2' WHERE subscriptions.unique_code='00000002'
    public void redo_game(ActionEvent actionEvent) {
        String game_name = redo_game_name.getText();
        int game_year= Integer.parseInt(redo_game_year.getText());
        Dev game_dev =(Dev)redo_game_dev.getValue();
        String original_name=redo_game_name_original.getText();
        if (game_name.isEmpty()||game_year==0|| game_dev ==null||original_name.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (bd.selectGame().contains(game_name)) {
            JOptionPane.showMessageDialog(null, "Такая игра уже есть", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            bd.redoGame(game_name,game_year, game_dev.getId(),original_name);
            JOptionPane.showMessageDialog(null, "Успешно добавлено", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void redo_achiv(ActionEvent actionEvent) {
        String achievement_name = redo_achiv_name.getText();
        Games achievement_game= (Games)redo_achiv_game.getValue();
        Gamers achievement_gamer =(Gamers)redo_achiv_gamer.getValue();
        String original_name=redo_achievement_name_original.getText();
        if (achievement_name.isEmpty()||achievement_game==null|| achievement_gamer ==null||original_name.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (bd.selectAchive().contains(achievement_name)) {
            JOptionPane.showMessageDialog(null, "Такое достижение уже есть", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            bd.redoAchievement(achievement_name,achievement_game.getId(), achievement_gamer.getId(),original_name);
            JOptionPane.showMessageDialog(null, "Успешно добавлено", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void redo_level(ActionEvent actionEvent) {
        String level_name = add_level_name.getText();
        Games achievement_game= (Games)add_level_game.getValue();
        String original_name=redo_achievement_name_original.getText();
        if (level_name.isEmpty()||achievement_game==null||original_name.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (bd.selectLevel().contains(level_name)) {
            JOptionPane.showMessageDialog(null, "Такой уровень уже есть", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            bd.redoLevel(level_name,achievement_game.getId(),original_name);
            JOptionPane.showMessageDialog(null, "Успешно добавлено", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void redo_dev(ActionEvent actionEvent) {
        String dev_name = add_dev_name.getText();
        int dev_year = Integer.parseInt(add_dev_year.getText());
        String original_name=redo_achievement_name_original.getText();
        if (dev_name.isEmpty()||dev_year==0||original_name.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (bd.selectDev().contains(dev_name)) {
            JOptionPane.showMessageDialog(null, "Такой уровень уже есть", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            bd.redoDev(dev_name,dev_year,original_name);
            JOptionPane.showMessageDialog(null, "Успешно добавлено", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void redo_purchase(ActionEvent actionEvent) {
        String code = add_purchase_code.getText();
        Games purchase_game = (Games)add_purchase_game.getValue();
        Gamers purchase_gamer=(Gamers)add_purchase_gamer.getValue();
        String original_name=redo_achievement_name_original.getText();
        if (code.isEmpty()|| purchase_game ==null||purchase_gamer==null||original_name.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (bd.selectPurchase().contains(code)) {
            JOptionPane.showMessageDialog(null, "Такая покупка уже есть", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            bd.redoPurchase(code, purchase_game.getId(),purchase_gamer.getId(),original_name);
            JOptionPane.showMessageDialog(null, "Успешно добавлено", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void redo_sub(ActionEvent actionEvent) {
        String code = add_sub_code.getText();
        Games sub_game = (Games)add_sub_game.getValue();
        Gamers sub_gamer =(Gamers)add_sub_gamer.getValue();
        String original_name=redo_achievement_name_original.getText();
        if (code.isEmpty()|| sub_game ==null|| sub_gamer ==null||original_name.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (bd.selectSub().contains(code)) {
            JOptionPane.showMessageDialog(null, "Такая подписка уже есть", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            bd.redoSub(code, sub_game.getId(), sub_gamer.getId(),original_name);
            JOptionPane.showMessageDialog(null, "Успешно добавлено", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void redo_mod(ActionEvent actionEvent) {
        String mod_name = add_mod_name.getText();
        Games sub_game = (Games)add_mod_game.getValue();
        String original_name=redo_achievement_name_original.getText();
        if (mod_name.isEmpty()|| sub_game ==null||original_name.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (bd.selectMod().contains(mod_name)) {
            JOptionPane.showMessageDialog(null, "Такой мод уже есть", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            bd.redoMod(mod_name, sub_game.getId(),original_name);
            JOptionPane.showMessageDialog(null, "Успешно добавлено", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void redo_tour(ActionEvent actionEvent) {

        String tour_name = add_tour_name.getText();
        String tour_location = add_tour_location.getText();
        int prize = Integer.parseInt(add_tour_prize.getText());
        Games tour_game = (Games)add_tour_game.getValue();
        String original_name=redo_achievement_name_original.getText();
        if (tour_name.isEmpty()|| tour_game ==null||tour_location.isEmpty()||prize==0||original_name.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (bd.selectTournament().contains(tour_name)) {
            JOptionPane.showMessageDialog(null, "Такой турнир уже есть", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            bd.redoTour(tour_name, tour_location,prize,tour_game.getId(),original_name);
            JOptionPane.showMessageDialog(null, "Успешно добавлено", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    //-----------------------------------------------
    public void del_gamer(ActionEvent actionEvent) {
        String gamer_nick=delete_gamer_nick.getText();
        if(gamer_nick.isEmpty()){
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            bd.delGamer(gamer_nick);
            JOptionPane.showMessageDialog(null, "Успешно удален", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void del_game(ActionEvent actionEvent) {
        String game_name=delete_game_name.getText();
        if(game_name.isEmpty()){
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            bd.delGame(game_name);
            JOptionPane.showMessageDialog(null, "Успешно удален", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void del_achievement(ActionEvent actionEvent) {
        String achievement_name=delete_achievement_name.getText();
        if(achievement_name.isEmpty()){
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            bd.delAchievement(achievement_name);
            JOptionPane.showMessageDialog(null, "Успешно удален", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void del_level(ActionEvent actionEvent) {
        String level_name =delete_level_name.getText();
        if(level_name.isEmpty()){
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            bd.delLevel(level_name);
            JOptionPane.showMessageDialog(null, "Успешно удален", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void del_dev(ActionEvent actionEvent) {
        String dev_name =delete_dev_name.getText();
        if(dev_name.isEmpty()){
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            bd.delDev(dev_name);
            JOptionPane.showMessageDialog(null, "Успешно удален", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void del_purchase(ActionEvent actionEvent) {
        String purchase_code =delete_purchase_code.getText();
        if(purchase_code.isEmpty()){
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            bd.delPurchase(purchase_code);
            JOptionPane.showMessageDialog(null, "Успешно удален", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void del_sub(ActionEvent actionEvent) {
        String sub_code =delete_sub_code.getText();
        if(sub_code.isEmpty()){
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            bd.delSub(sub_code);
            JOptionPane.showMessageDialog(null, "Успешно удален", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void del_mod(ActionEvent actionEvent) {
        String mod_name =delete_mod_name.getText();
        if(mod_name.isEmpty()){
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            bd.delMod(mod_name);
            JOptionPane.showMessageDialog(null, "Успешно удален", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void del_tour(ActionEvent actionEvent) {
        String tour_name =delete_tour_name.getText();
        if(tour_name.isEmpty()){
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            bd.delTour(tour_name);
            JOptionPane.showMessageDialog(null, "Успешно удален", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}