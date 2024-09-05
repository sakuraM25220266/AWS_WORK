package com.example.janken;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * プレイヤーの手の入力、CPUの手の取得、じゃんけんの判定、判定結果の表示、対戦履歴の書き込みの一連の流れを行うクラス。
 */
public class Play {
    Judge judge = new Judge();
    Logger logger = LogManager.getLogger();

    /**
     * じゃんけんの一連の流れを行う。<br>
     * SelectOptionクラスを実行し、オプション選択でプレイヤーが0を入力した際に実行される。<br>
     */
    public void playJanken() {
        Player player = new Player();
        Npc npc = new Npc();
        Judge judge = new Judge();
        MatchRecord matchRecord = new MatchRecord();

        // プレイヤーの手を決定する
        String playerHand = player.decidePlayerHand();
        logger.info("あなた:" + playerHand);

        // NPCの手を決定する
        String npcHand = npc.decideNpcHand();
        logger.info("対戦相手:" + npcHand);

        // 勝敗を判定し、結果を表示する
        judge.judge(player, npc);
        int result = judge.getResult();
        judge.show(result);

        matchRecord.writeRecord(playerHand, npcHand, result);
    }
}
