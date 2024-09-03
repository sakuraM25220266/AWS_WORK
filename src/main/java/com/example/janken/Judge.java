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
     * @param npu    <br>
     * @param player <br>
     */
    public void judge(Player player, Npu npu) {
        if (player.getInput() == 0) {
            result = judgeRock(npu.getNpu());
        } else if (player.getInput() == 1) {
            result = judgeScissors(npu.getNpu());
        } else if (player.getInput() == 2) {
            result = judgePaper(npu.getNpu());
        }
    }

    /**
     * プレイヤーの出した手がグーのときに、勝敗を判定し結果を表示する。<br>
     * npu == 0のとき、NPUの手はグー<br>
     * npu == 1のとき、NPUの手はチョキ<br>
     * npu == 2のとき、NPUの手はパー<br>
     * 戻り値が10のとき、あいこ<br>
     * 戻り値が20のとき、勝ち<br>
     * 戻り値が30のとき、負け<br>
     * 
     * @param npu <br>
     */
    public int judgeRock(int npu) {
        if (npu == 0) {
            return 10;
        } else if (npu == 1) {
            return 20;
        } else
            return 30;
    }

    /**
     * プレイヤーの出した手がチョキのときに、勝敗を判定し結果を表示する。<br>
     * npu == 0のとき、NPUの手はグー<br>
     * npu == 1のとき、NPUの手はチョキ<br>
     * npu == 2のとき、NPUの手はパー<br>
     * 
     * @param npu <br>
     */
    public static int judgeScissors(int npu) {
        if (npu == 0) {
            return 30;
        } else if (npu == 1) {
            return 10;
        } else
            return 20;
    }

    /**
     * プレイヤーの出した手がパーのときに、勝敗を判定し結果を表示する。<br>
     * npu == 0のとき、NPUの手はグー<br>
     * npu == 1のとき、NPUの手はチョキ<br>
     * npu == 2のとき、NPUの手はパー<br>
     * 
     * @param npu <br>
     */
    public static int judgePaper(int npu) {
        if (npu == 0) {
            return 20;
        } else if (npu == 1) {
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
            logger.info(LOSE + "あなたの負けです！");
        }
    }

    public int getResult() {
        return result;
    }
}
