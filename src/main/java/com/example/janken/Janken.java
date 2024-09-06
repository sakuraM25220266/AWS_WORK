package com.example.janken;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * じゃんけんを行うクラス
 */
public class Janken {
    private String result;
    Player player = new Player();
    Npc npc = new Npc();
    JankenHistory jankenHistory = new JankenHistory();
    Logger logger = LogManager.getLogger();

    /**
     * コンソールに0～2を入力し、その値によってプレイヤーのじゃんけんの手を決める。<br>
     * 0～2以外が入力されたときは、正しく入力されるまで繰り返す。
     */
    private void decidePlayerHand() {
        int input;
        Scanner scan = new Scanner(System.in);

        while (true) {
            try {
                logger.info("出したい手を0～2の中から半角で入力してください(0:グー、1:チョキ、2:パー)");
                input = scan.nextInt();

                if (input == 0) {
                    player.setHand(Hand.ROCK.getJapanese());
                    break;
                } else if (input == 1) {
                    player.setHand(Hand.SCISSORS.getJapanese());
                    break;
                } else if (input == 2) {
                    player.setHand(Hand.PAPER.getJapanese());
                    break;
                } else {
                    logger.info("入力できるのは0~2までの範囲です。もう一度入力してください。");
                }
            } catch (InputMismatchException e) {
                logger.info("文字は入力できません。もう一度入力してください。");
                scan.next();
            }
        }
    }

    /**
     * 0～2の乱数を生成し、その値によってNPCのじゃんけんの手を決める。
     */
    private void decideNpcHand() {
        int randomNpc;
        // 0～2までの乱数を生成する
        Random rand = new Random();
        randomNpc = rand.nextInt(3);
        // 生成した乱数をもとに、NPCの手を表示する
        // 0の場合はグー、1の場合はチョキ、2の場合はパー
        if (randomNpc == 0) {
            npc.setHand(Hand.ROCK.getJapanese());
        } else if (randomNpc == 1) {
            npc.setHand(Hand.SCISSORS.getJapanese());
        } else if (randomNpc == 2) {
            npc.setHand(Hand.PAPER.getJapanese());
        }
    }

    /**
     * じゃんけんの判定を行う。
     * @param player
     * @param npc
     * @return result
     */
    private String judge(Player player, Npc npc){
        if(player.getHand() == npc.getHand()){
            return JudgeResult.DRAW.getResult();
        }else if((player.getHand() == Hand.ROCK.getJapanese() && npc.getHand() == Hand.SCISSORS.getJapanese()) ||
                 (player.getHand() == Hand.SCISSORS.getJapanese() && npc.getHand() == Hand.PAPER.getJapanese()) ||
                 (player.getHand() == Hand.PAPER.getJapanese() && npc.getHand() == Hand.ROCK.getJapanese())){
            return JudgeResult.WIN.getResult();
        }else{
            return JudgeResult.LOSE.getResult();
        }
    }

    /**
     * じゃんけんの一連の流れを行い、結果をDBに登録する。<br>
     * SelectOptionクラスを実行し、オプション選択でプレイヤーが0を入力した際に実行される。<br>
     * @throws SQLException 
     */
    public void start() {
        // プレイヤーの手を決定する
        decidePlayerHand();
        logger.info("あなた:" + player.getHand());

        // NPCの手を決定する
        decideNpcHand();
        logger.info("対戦相手:" + npc.getHand());

        // 勝敗を判定する
        result = judge(player, npc);
        logger.info(result + "です");

        //結果をDBに登録する
        try {
            jankenHistory.write();
        } catch (SQLException e) {
            e.printStackTrace();
        }
   }

    //ゲッターの定義
    public String getResult() {
        return result;
    }
}
