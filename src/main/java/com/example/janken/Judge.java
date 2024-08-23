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
     * プレイヤーの出した手によって判定するメソッドを分ける。
     * プレイヤーの手がグーのときjudgeRock()メソッドを実行する。
     * プレイヤーの手がチョキのときjudgeScissors()メソッドを実行する。
     * プレイヤーの手がパーのときjudgePaper()メソッドを実行する。
     * @param npu 
     * @param player 
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
     * プレイヤーの出した手がグーのときに、勝敗を判定し結果を表示する。
     * npu == 0のとき、NPUの手はグー
     * npu == 1のとき、NPUの手はチョキ
     * npu == 2のとき、NPUの手はパー
     * 戻り値が10のとき、あいこ
     * 戻り値が20のとき、勝ち
     * 戻り値が30のとき、負け
     * @param npu
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
     * プレイヤーの出した手がチョキのときに、勝敗を判定し結果を表示する。
     * npu == 0のとき、NPUの手はグー
     * npu == 1のとき、NPUの手はチョキ
     * npu == 2のとき、NPUの手はパー
     * @param npu
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
     * プレイヤーの出した手がパーのときに、勝敗を判定し結果を表示する。
     * npu == 0のとき、NPUの手はグー
     * npu == 1のとき、NPUの手はチョキ
     * npu == 2のとき、NPUの手はパー
     * @param npu
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
     * じゃんけんの結果を表示する。
     * result == 10のとき、あいこ
     * result == 20のとき、プレイヤーの勝ち
     * result == 30のとき、プレイヤーの負け
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

    public int getResult(){
        return result;
    }
}
