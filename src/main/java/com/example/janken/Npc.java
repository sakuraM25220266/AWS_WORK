package com.example.janken;

import java.util.Random;

/**
 * NPCのじゃんけんの手を取得するクラス。<br>
 * 0～2の乱数を生成し、その値によってNpcの手が決まる。<br>
 * 0:グー<br>
 * 1:チョキ<br>
 * 2:パー<br>
 */
public class Npc {
    final String ROCK = "グー";
    final String SCISSORS = "チョキ";
    final String PAPER = "パー";
    private int npc;
    private String npcHand = null;

    /**
     * 0～2の乱数を生成し、その値によってCPUのじゃんけんの手を取得する。<br>
     * @return npcHand <br>
     */
    public String decideNpcHand() {
        // 0～2までの乱数を生成する
        Random rand = new Random();
        npc = rand.nextInt(3);
        // 生成した乱数をもとに、NPCの手を表示する
        // 0の場合はグー、1の場合はチョキ、2の場合はパー
        if (npc == 0) {
            npcHand = ROCK;
        } else if (npc == 1) {
            npcHand = SCISSORS;
        } else if (npc == 2) {
            npcHand = PAPER;
        }
        return npcHand;
    }

    public int getNpc(){
        return npc;
    }

    public String getNpcHand(){
        return npcHand;
    }
}
