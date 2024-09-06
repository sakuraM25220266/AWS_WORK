package com.example.janken;

public enum JudgeResult {
    DRAW("あいこ"),
    WIN("勝ち"),
    LOSE("負け");

    // フィールドの定義
    private String result;

    // コンストラクタの定義
    private JudgeResult(String result) {
        this.result = result;
    }

    //ゲッターの定義
    public String getResult() {
        return result;
    }
}
