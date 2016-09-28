package com.lemon.dao;

/**
 * Created by Wang Haobo on 2016/9/27.
 */
public class Vocabulary {
    private int id;
    private String word;
    private int unit_order;
    private int unit_disorder;
    private String phonetic_uk;
    private String phonetic_usa;
    private String paraphrase_en;
    private String paraphrase_zh;
    private String sample_sentence1;
    private String sample_sentence2;


    public Vocabulary(){
        //Do nothing
    }
    public void setId(int id ){
        this.id=id;
    }
    public int getId(){
        return id;
    }

    private String  getWord(){
        return word;
    }


}
