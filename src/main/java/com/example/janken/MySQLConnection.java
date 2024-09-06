package com.example.janken;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {
    public static void main(String[] args) {
        // MySQL接続情報
        // データベースのURL
        String url = "jdbc:mysql://localhost:3306/mysql";
        // データベースのユーザー名
        String username = "root"; 
        // データベースのパスワード
        String password = "cnct2d6"; 

        // MySQLへの接続
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("MySQLに接続しました。");

            // SQLクエリの実行
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT * FROM janken_record";
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    // 結果の処理
                    while (resultSet.next()) {
                        int id = resultSet.getInt("ID");
                        String date = resultSet.getString("DATE");
                        String your_hand = resultSet.getString("YOUR_HAND");
                        String npc_hand = resultSet.getString("NPC_HAND");
                        String result = resultSet.getString("RESULT");
                        System.out.println("ID: " + id + ", DATE: " + date + ", YOUR_HAND:" + your_hand + ", NPC_HAND:" + npc_hand + ", RESULT:" + result);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("MySQLへの接続に失敗しました。");
            e.printStackTrace();
        }
    }
}