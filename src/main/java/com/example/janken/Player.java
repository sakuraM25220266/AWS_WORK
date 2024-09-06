package com.example.janken;

/**
 * プレイヤーの手のモデルクラス。
 */
public class Player {
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