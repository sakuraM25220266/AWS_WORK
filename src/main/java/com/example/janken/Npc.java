package com.example.janken;



/**
 * NPCのじゃんけんの手を取得するクラス。<br>
 * 0～2の乱数を生成し、その値によってNpcの手が決まる。<br>
 * 0:グー<br>
 * 1:チョキ<br>
 * 2:パー<br>
 */
public class Npc {
    // じゃんけんで出す手
    private String hand = null;
            
    // セッター
    public void setHand(String hand) {
        this.hand = hand;
    }
    
    // ゲッター
    public String getHand() {
        return hand;
    }
    

    

   

    
}
