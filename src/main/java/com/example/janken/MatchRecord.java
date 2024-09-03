package com.example.janken;

import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * じゃんけんの対戦履歴を管理するクラス。<br>
 * CSVファイルへの対戦履歴の書き込み、読み込みを行う。<br>
 */
public class MatchRecord {
    public String path = "C:\\Users\\9004091159\\Desktop\\JankenRecord.csv";
    Logger logger = LogManager.getLogger();

    /**
     * じゃんけんをした時の日時、プレイヤーの手、NPUの手、結果を、CSVファイルに書き込む。F
     */
    public void writeRecord(String playerHand, String npuHand, int result) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));

            // じゃんけんを行った時の日時を取得する
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

            // String playerHand = player.getPlayerHand();
            // String npuHand = npu.getNpuHand();

            String resultText;
            if (result == 10) {
                resultText = new Judge().DRAW;
            } else if (result == 20) {
                resultText = new Judge().WIN;
            } else if (result == 30) {
                resultText = new Judge().LOSE;
            } else {
                resultText = "無効な結果";
            }
            // じゃんけんを行った日時、プレイヤーの手、NPUの手、じゃんけんの結果をカンマ区切りでファイルに書き込む
            String record = String.format("%s,%s,%s,%s", formatter.format(now), playerHand, npuHand, resultText);
            pw.println(record);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            logger.info("ファイルの書き込みに失敗しました。");
            e.printStackTrace();
        }
    }

    /**
     * CSVファイルに書き込まれた対戦履歴を表示する。
     */
    public void show() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));

            String line;
            // 1行ずつCSVファイルを読み込む
            while ((line = br.readLine()) != null) {
                // 行をカンマ区切りで配列に変換する
                String[] data = line.split(",", 4);

                if (data.length == 4) {
                    logger.info("日時：" + data[0] + "、あなた：" + data[1] + "、相手：" + data[2] + "、結果：" + data[3]);
                }
            }
            br.close();

        } catch (IOException e) {
            logger.info("ファイルの読み込みに失敗しました。");
        }

    }
}