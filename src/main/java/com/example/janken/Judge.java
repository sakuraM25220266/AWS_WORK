package com.example.janken;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * じゃんけんの勝敗あいこを判断するクラス。
 */
public class Judge {
    final String DRAW = "あいこ";
    final String WIN = "あなたの勝ち";
    final String LOSE = "あなたの負け";
    int result;

    Logger logger = LogManager.getLogger();

    /**
     * プレイヤーの出した手によって判定するメソッドを分ける。<br>
     * プレイヤーの手がグーのときjudgeRock()メソッドを実行する。<br>
     * プレイヤーの手がチョキのときjudgeScissors()メソッドを実行する。<br>
     * プレイヤーの手がパーのときjudgePaper()メソッドを実行する。<br>
     * 
     * @param npc    <br>
     * @param player <br>
     */
    public void judge(Player player, Npc npc) {
        if (player.getInpct() == 0) {
            result = judgeRock(npc.getNpc());
        } else if (player.getInpct() == 1) {
            result = judgeScissors(npc.getNpc());
        } else if (player.getInpct() == 2) {
            result = judgePaper(npc.getNpc());
        }
    }

    /**
     * プレイヤーの出した手がグーのときに、勝敗を判定し結果を表示する。<br>
     * npc == 0のとき、NPCの手はグー<br>
     * npc == 1のとき、NPCの手はチョキ<br>
     * npc == 2のとき、NPCの手はパー<br>
     * 戻り値が10のとき、あいこ<br>
     * 戻り値が20のとき、勝ち<br>
     * 戻り値が30のとき、負け<br>
     * 
     * @param npc <br>
     */
    public int judgeRock(int npc) {
        if (npc == 0) {
            return 10;
        } else if (npc == 1) {
            return 20;
        } else
            return 30;
    }

    /**
     * プレイヤーの出した手がチョキのときに、勝敗を判定し結果を表示する。<br>
     * npc == 0のとき、NPCの手はグー<br>
     * npc == 1のとき、NPCの手はチョキ<br>
     * npc == 2のとき、NPCの手はパー<br>
     * 
     * @param npc <br>
     */
    public static int judgeScissors(int npc) {
        if (npc == 0) {
            return 30;
        } else if (npc == 1) {
            return 10;
        } else
            return 20;
    }

    /**
     * プレイヤーの出した手がパーのときに、勝敗を判定し結果を表示する。<br>
     * npc == 0のとき、NPCの手はグー<br>
     * npc == 1のとき、NPCの手はチョキ<br>
     * npc == 2のとき、NPCの手はパー<br>
     * 
     * @param npc <br>
     */
    public static int judgePaper(int npc) {
        if (npc == 0) {
            return 20;
        } else if (npc == 1) {
            return 30;
        } else
            return 10;
    }

    /**
     * じゃんけんの結果を表示する。<br>
     * result == 10のとき、あいこ<br>
     * result == 20のとき、プレイヤーの勝ち<br>
     * result == 30のとき、プレイヤーの負け<br>
     */
    public void show(int result) {
        if (result == 10) {
            logger.info(DRAW + "です！");
        } else if (result == 20) {
            logger.info(WIN + "です！");
        } else if (result == 30) {
            logger.info(LOSE + "です！");
        }
    }

    public int getResult() {
        return result;
    }
}
