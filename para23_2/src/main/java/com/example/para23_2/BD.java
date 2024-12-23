package com.example.para23_2;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BD {
    private static final String URL = "jdbc:mysql://localhost/gamingplatform";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Gamers> selectGamer() {
        List<Gamers> gamers = new ArrayList<>();
        Connection connection = null;
        try {
            connection = openConnection();
            String q = "SELECT * FROM `gamers`,`games` WHERE games.id_game=gamers.game_id";
            PreparedStatement statement = connection.prepareStatement(q);
            ResultSet r = statement.executeQuery();
            while (r.next()) {
                String nick = r.getString("gamer_nick");
                int year = r.getInt("reg_fullyears");
                String game = r.getString("game_name");
                gamers.add(new Gamers(r.getInt("id_gamer"),nick,year,game));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return gamers;
    }
    public List<Games> selectGame() {
        List<Games> games = new ArrayList<>();
        Connection connection = null;
        try {
            connection = openConnection();
            String q = "SELECT * FROM `developers`,`games` WHERE games.developer_id=developers.id_developer";
            PreparedStatement statement = connection.prepareStatement(q);
            ResultSet r = statement.executeQuery();
            while (r.next()) {
                String name = r.getString("game_name");
                int year = r.getInt("game_year");
                String dev = r.getString("developer_name");
                games.add(new Games(r.getInt("id_game"), name,year, dev));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return games;
    }
    public List<Dev> selectDev() {
        List<Dev> devs = new ArrayList<>();
        Connection connection = null;
        try {
            connection = openConnection();
            String q = "SELECT * FROM `developers`";
            PreparedStatement statement = connection.prepareStatement(q);
            ResultSet r = statement.executeQuery();
            while (r.next()) {
                int year = r.getInt("developer_year");
                String dev = r.getString("developer_name");
                devs.add(new Dev(r.getInt("id_developer"),dev, year));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return devs;
    }
    public List<Achive> selectAchive() {
        List<Achive> achive = new ArrayList<>();
        Connection connection = null;
        try {
            connection = openConnection();
            String q = "SELECT * FROM `achievements`,`gamers`,`games` WHERE achievements.game_id=games.id_game AND achievements.gamer_id=gamers.id_gamer";//дописать
            PreparedStatement statement = connection.prepareStatement(q);
            ResultSet r = statement.executeQuery();
            while (r.next()) {
                String name = r.getString("achievement_name");
                String game = r.getString("game_name");
                String gamer = r.getString("gamer_nick");
                achive.add(new Achive(r.getInt("id_achievement"), name,game, gamer));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return achive;
    }
    public List<Levels> selectLevel() {
        List<Levels> levels = new ArrayList<>();
        Connection connection = null;
        try {
            connection = openConnection();
            String q = "SELECT * FROM `levels`,`games` WHERE levels.game_id=games.id_game";
            PreparedStatement statement = connection.prepareStatement(q);
            ResultSet r = statement.executeQuery();
            while (r.next()) {
                String name = r.getString("level_name");
                String game = r.getString("game_name");
                levels.add(new Levels(r.getInt("id_level"), name,game));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return levels;
    }
    public List<Reviews> selectReview() {
        List<Reviews> reviews = new ArrayList<>();
        Connection connection = null;
        try {
            connection = openConnection();
            String q = "SELECT * FROM `reviews`,`games` WHERE reviews.game_id=games.id_game";
            PreparedStatement statement = connection.prepareStatement(q);
            ResultSet r = statement.executeQuery();
            while (r.next()) {
                String name = r.getString("review_text");
                String game = r.getString("game_name");
                reviews.add(new Reviews(r.getInt("id_review"), name,game));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return reviews;
    }
    public List<Purchases> selectPurchase() {
        List<Purchases> purchases = new ArrayList<>();
        Connection connection = null;
        try {
            connection = openConnection();
            String q = "SELECT * FROM `purchases`,`gamers`,`games` WHERE purchases.gamer_id=gamers.id_gamer AND purchases.game_id=games.id_game";
            PreparedStatement statement = connection.prepareStatement(q);
            ResultSet r = statement.executeQuery();
            while (r.next()) {
                String name = r.getString("unique_code");
                String gamer = r.getString("gamer_nick");
                String game = r.getString("game_name");
                purchases.add(new Purchases(r.getInt("id_purchase"), name,gamer,game));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return purchases;
    }
    public List<Subs> selectSub() {
        List<Subs> subs = new ArrayList<>();
        Connection connection = null;
        try {
            connection = openConnection();
            String q = "SELECT * FROM `subscriptions`,`gamers`,`games` WHERE subscriptions.gamer_id=gamers.id_gamer AND subscriptions.game_id=games.id_game";
            PreparedStatement statement = connection.prepareStatement(q);
            ResultSet r = statement.executeQuery();
            while (r.next()) {
                String name = r.getString("unique_code");
                String gamer = r.getString("gamer_nick");
                String game = r.getString("game_name");
                subs.add(new Subs(r.getInt("id_subscription"), name,gamer,game));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return subs;
    }
    public List<Mods> selectMod() {
        List<Mods> mods = new ArrayList<>();
        Connection connection = null;
        try {
            connection = openConnection();
            String q = "SELECT * FROM `mods`,`games` WHERE mods.game_id=games.id_game";
            PreparedStatement statement = connection.prepareStatement(q);
            ResultSet r = statement.executeQuery();
            while (r.next()) {
                String name = r.getString("mod_name");
                String game = r.getString("game_name");
                mods.add(new Mods(r.getInt("id_mod"), name,game));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return mods;
    }
    public List<Tournament> selectTournament() {
        List<Tournament> tournaments = new ArrayList<>();
        Connection connection = null;
        try {
            connection = openConnection();
            String q = "SELECT * FROM `tournaments`,`games` WHERE tournaments.game_id=games.id_game";
            PreparedStatement statement = connection.prepareStatement(q);
            ResultSet r = statement.executeQuery();
            while (r.next()) {
                String name = r.getString("tournament_name");
                String location = r.getString("tournament_location");
                int money=r.getInt("tournament_moneyprize");
                String game = r.getString("game_name");
                tournaments.add(new Tournament(r.getInt("id_tournament"), name,location,money,game));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return tournaments;
    }
    public void addGamer(String name,int year,int game)
    {
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "INSERT INTO gamers (gamer_nick, reg_fullyears, game_id) VALUES (?, ?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2,year);
            statement.setInt(3,game);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Игрок добавлен", "Игрок добавлен", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void addGame(String name,int year,int dev)
    {
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "INSERT INTO games (game_name, game_year, developer_id) VALUES (?, ?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2,year);
            statement.setInt(3,dev);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Игра добавлена", "Игра добавлена", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void addAchievement(String name,int game,int gamer)
    {
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "INSERT INTO achievements (achievement_name, game_id, gamer_id) VALUES (?, ?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2,game);
            statement.setInt(3,gamer);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Достижение добавлено", "Достижение добавлено", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void addLevel(String name,int game)
    {
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "INSERT INTO levels (level_name, game_id) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2,game);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Уровень добавлен", "Уровень добавлен", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void addDev(String name,int year)
    {
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "INSERT INTO developers (developer_name, developer_year) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2,year);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Разработчик добавлен", "Разработчик добавлен", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void addReview(String text,int game)
    {
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "INSERT INTO reviews (review_text, game_id) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, text);
            statement.setInt(2,game);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Отзыв добавлен", "Отзыв добавлен", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void addPurchase(String code,int game,int gamer)
    {
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "INSERT INTO purchases (unique_code, game_id,gamer_id) VALUES (?,?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, code);
            statement.setInt(2,game);
            statement.setInt(3,gamer);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Покупка добавлена", "Покупка добавлена", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void addSub(String code,int game,int gamer)
    {
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "INSERT INTO subscriptions (unique_code, game_id,gamer_id) VALUES (?,?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, code);
            statement.setInt(2,game);
            statement.setInt(3,gamer);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Подписка добавлена", "Подписка добавлена", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void addMod(String mod,int game)
    {
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "INSERT INTO mods (mod_name, game_id) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, mod);
            statement.setInt(2,game);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Мод добавлен", "Мод добавлен", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void addTour(String tour,String location,int prize,int game)
    {
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "INSERT INTO tournaments (tournament_name,tournament_location,tournament_moneyprize, game_id) VALUES (?, ?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, tour);
            statement.setString(2, location);
            statement.setInt(3,prize);
            statement.setInt(4,game);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Турнир добавлен", "Турнир добавлен", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void redoGame(String name,int year,int dev,String original)
    {
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "UPDATE games SET game_name=?, game_year=?, developer_id=? WHERE game_name=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2,year);
            statement.setInt(3,dev);
            statement.setString(4,original);
            statement.executeUpdate();}
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void redoAchievement(String name,int game,int gamer,String original)
    {
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "UPDATE achievements SET achievement_name=?, game_id=?, gamer_id=? WHERE achievement_name=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2,game);
            statement.setInt(3,gamer);
            statement.setString(4,original);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void redoLevel(String name,int game,String original)
    {
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "UPDATE levels SET level_name=?, game_id=? WHERE level_name=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2,game);
            statement.setString(3,original);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void redoDev(String name,int year,String original)
    {
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "UPDATE developers SET developer_name=?, developer_year=? WHERE developer_name=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2,year);
            statement.setString(3,original);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void redoPurchase(String code,int game,int gamer, String original)
    {
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "UPDATE purchases SET unique_code=?, game_id=?,gamer_id=? WHERE unique_code=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, code);
            statement.setInt(2,game);
            statement.setInt(3,gamer);
            statement.setString(4,original);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void redoSub(String code,int game,int gamer,String original)
    {
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "UPDATE subscriptions SET unique_code=?, game_id=?,gamer_id=? WHERE unique_code=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, code);
            statement.setInt(2,game);
            statement.setInt(3,gamer);
            statement.setString(4,original);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void redoMod(String mod,int game, String original)
    {
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "UPDATE mods SET mod_name=?, game_id=? WHERE mod_name=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, mod);
            statement.setInt(2,game);
            statement.setString(3,original);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void redoTour(String tour,String location,int prize,int game,String original)
    {
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "UPDATE tournaments SET tournament_name=?, tournament_location=?,tournament_moneyprize=?,game_id=? WHERE tournament_name=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, tour);
            statement.setString(2, location);
            statement.setInt(3,prize);
            statement.setInt(4,game);
            statement.setString(5,original);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void delGamer(String nick){
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "DELETE FROM gamers WHERE gamer_nick=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,nick);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void delGame(String name){
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "DELETE FROM games WHERE game_name=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,name);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void delAchievement(String name){
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "DELETE FROM achievements WHERE achievement_name=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,name);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void delLevel(String name){
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "DELETE FROM levels WHERE level_name=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,name);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void delDev(String name){
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "DELETE FROM developers WHERE developers_name=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,name);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void delPurchase(String code){
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "DELETE FROM purchases WHERE unique_code=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,code);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void delSub(String code){
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "DELETE FROM subscriptions WHERE unique_code=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,code);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void delMod(String name){
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "DELETE FROM mods WHERE mod_name=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,name);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
    public void delTour(String name){
        Connection connection = null;
        try{
            connection = openConnection();
            String query = "DELETE FROM tournaments WHERE tournament_name=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,name);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection); }
    }
}