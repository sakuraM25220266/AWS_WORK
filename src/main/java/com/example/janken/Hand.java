package com.example.janken;

public enum Hand {
    ROCK("グー"),
    SCISSORS("チョキ"),
    PAPER("パー");

    // フィールドの定義
    private String japanese;

    // コンストラクタの定義
    private Hand(String japanese) {
        this.japanese = japanese;
    }

    //ゲッターの定義
    public String getJapanese() {
        return japanese;
    }
}