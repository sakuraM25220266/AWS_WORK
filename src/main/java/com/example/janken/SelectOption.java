package com.example.janken;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 3つのオプションを表示し、プレイヤーに0～2のいずれかを入力してもらう。<br>
 * 入力された値によって、下記のオプションを実行し、オプションの実行後に再度オプション選択から繰り返すクラス。<br>
 * 0:プレイヤーとCPUがじゃんけんを行う。<br>
 * 1:じゃんけんの対戦履歴を表示する。<br>
 * 2:プログラムを終了する。<br>
 * 0～2以外が入力された場合は再度入力を促す。<br>
 */
public class SelectOption {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Play play = new Play();
        MatchRecord matchRecord = new MatchRecord();
        Logger logger = LogManager.getLogger();

        while (true) {
            logger.info("オプションを選んで数字を入力してください。");
            logger.info("0:じゃんけんをする。");
            logger.info("1:じゃんけんの対戦履歴を表示する。");
            logger.info("2:終了する。");
            logger.info("選択:");

            int option = scan.nextInt();

            switch (option) {
                case 0:
                    play.playJanken();
                    break;
                case 1:
                    matchRecord.show();
                    break;
                case 2:
                    logger.info("プログラムを終了します");
                    scan.close();
                    return;
                default:
                    logger.info("無効な値が入力されました。もう一度選択してください。");
                    break;
            }
        }
    }
}
