package com.example.janken;

import java.util.Random;

/**
 * NPUのじゃんけんの手を取得するクラス。<br>
 * 0～2の乱数を生成し、その値によってNpuの手が決まる。<br>
 * 0:グー<br>
 * 1:チョキ<br>
 * 2:パー<br>
 */
public class Npu {
    final String ROCK = "グー";
    final String SCISSORS = "チョキ";
    final String PAPER = "パー";
    private int npu;
    private String npuHand = null;

    /**
     * 0～2の乱数を生成し、その値によってCPUのじゃんけんの手を取得する。<br>
     * @return npuHand <br>
     */
    public String decideNpuHand() {
        // 0～2までの乱数を生成する
        Random rand = new Random();
        npu = rand.nextInt(3);
        // 生成した乱数をもとに、NPUの手を表示する
        // 0の場合はグー、1の場合はチョキ、2の場合はパー
        if (npu == 0) {
            npuHand = ROCK;
        } else if (npu == 1) {
            npuHand = SCISSORS;
        } else if (npu == 2) {
            npuHand = PAPER;
        }
        return npuHand;
    }

    public int getNpu(){
        return npu;
    }

    public String getNpuHand(){
        return npuHand;
    }
}
