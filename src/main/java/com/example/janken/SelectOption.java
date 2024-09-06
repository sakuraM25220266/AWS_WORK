package com.example.janken;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 3つのオプションを表示し、プレイヤーに0～2のいずれかを入力してもらう。<br>
 * 入力された値によって、下記のオプションを実行し、オプションの実行後に再度オプション選択から繰り返すクラス。<br>
 * 0:プレイヤーとNPCがじゃんけんを行う。<br>
 * 1:じゃんけんの対戦履歴を表示する。<br>
 * 2:プログラムを終了する。<br>
 * 0～2以外が入力された場合は再度入力を促す。
 */
public class SelectOption {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Janken janken = new Janken();
        JankenHistory jankenHistory = new JankenHistory();
        Logger logger = LogManager.getLogger();

        while (true) {
            logger.info("オプションを選んで数字を入力してください。");
            logger.info("0:じゃんけんをする。");
            logger.info("1:過去10回の対戦成績を表示する。");
            logger.info("2:月ごとの対戦成績を表示する。");
            logger.info("3:終了する。");
            logger.info("選択:");

            int option = scan.nextInt();

            switch (option) {
                case 0:
                    janken.start();
                    break;
                case 1:
                    logger.info("過去10回の対戦成績を表示します。");
                    break;
                case 2:
                    logger.info("月ごとの対戦成績を表示します。");
                    scan.close();
                    return;
                case 3:
                    logger.info("プログラムを終了します。");
                default:
                    logger.info("無効な値が入力されました。もう一度選択してください。");
                    break;
            }
        }
    }
}
