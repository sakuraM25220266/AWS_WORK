package com.example.janken;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * じゃんけんの対戦結果のDB登録、過去10回の対戦成績の表示、月ごとの対戦成績の表示を行うクラス。
 */
public class JankenHistory {
    Player player = new Player();
    Npc npc = new Npc();
    Janken janken = new Janken();
    Logger logger = LogManager.getLogger();

    //接続用の情報をフィールドに定数として定義
    private static String URL = "jdbc:mysql://localhost:3306/mysql";
    private static String USERNAME = "root";
    private static String PASSWORD = "cnct2d6";

    /**
     * じゃんけんの結果をDBに登録する。
     * @throws SQLException
     */
    public void write() throws SQLException{
        //MySQLに接続する
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            // じゃんけんの結果を追加するためのSQL文を定義する
            String sql = "INSERT INTO janken_history(DATE, YOUR_HAND, NPC_HAND, RESULT) VALUES( NOW(), ?, ?, ?)";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                //現在日時を取得する
                // LocalDateTime now
                //PreparedStatementに現在日時、プレイヤーの手、NPCの手、結果をセットする。
                preparedStatement.setString(1, player.getHand());
                preparedStatement.setString(2, npc.getHand());
                preparedStatement.setString(3, janken.getResult());

                //アップデートを実行する
                preparedStatement.executeUpdate();
            }catch (SQLException e) {
                logger.info("結果をDBに登録できませんでした。");
                e.printStackTrace();
            }
        } 
    }

}
