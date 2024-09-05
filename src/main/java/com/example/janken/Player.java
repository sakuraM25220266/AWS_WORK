package com.example.janken;

import java.util.Scanner;
import java.util.InputMismatchException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * プレイヤーのじゃんけんの手を取得するクラス。<br>
 * コンソールに0～2を入力してもらい、その値によってプレイヤーのじゃんけんの手が決まる。<br>
 * 0:グー<br>
 * 1:チョキ<br>
 * 2:パー<br>
 */
public class Player {
    final String ROCK = "グー";
    final String SCISSORS = "チョキ";
    final String PAPER = "パー";
    private int inpct;
    private String playerHand = null;

    Logger logger = LogManager.getLogger();

    /**
     * コンソールに0～2を入力し、その値によってプレイヤーのじゃんけんの手を取得する。<br>
     * 0～2以外が入力されたときは、正しく入力されるまで繰り返す。<br>
     * <br>
     * @return playerhand<br>
     */
    public String decidePlayerHand() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            try {
                logger.info("出したい手を0～2の中から半角で入力してください(0:グー、1:チョキ、2:パー)");
                inpct = scan.nextInt();

                if (inpct == 0) {
                    playerHand = ROCK;
                    break;
                } else if (inpct == 1) {
                    playerHand = SCISSORS;
                    break;
                } else if (inpct == 2) {
                    playerHand = PAPER;
                    break;
                } else {
                    logger.info("入力できるのは0~2までの範囲です。もう一度入力してください。");
                }
            } catch (InputMismatchException e) {
                logger.info("文字は入力できません。もう一度入力してください。");
                scan.next();
            }
        }
        return playerHand;
    }


    public int getInpct(){
        return inpct;
    }

    public String getPlayerHand(){
        return playerHand;
    }
}