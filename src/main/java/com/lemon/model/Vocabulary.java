package com.lemon.model;

/**
 * Created by Wang Haobo on 2016/9/27.
 */
public class Vocabulary {
    private int id;
    private String word;
    private int unit;
    private String phonetic_uk;
    private String phonetic_usa;
    private String paraphrase_en;
    private String paraphrase_zh;
    private String sample_sentence1;
    private String sample_sentence2;


    public Vocabulary() {
        //Do nothing
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getWord() {
        return word;
    }
    public void setWord(String word){
        this.word=word;
    }
    public void setUnit(int unit){
        this.unit = unit;
    }

    public int getUnit() {
        return unit;
    }
    public String getPhonetic_uk(){
        return phonetic_uk;
    }
    public void setPhonetic_uk(String phonetic_uk){
        this.phonetic_uk=phonetic_uk;
    }
    public String getPhonetic_usa(){
        return phonetic_usa;
    }
    public void setPhonetic_usa(String phonetic_usa){
        this.phonetic_usa=phonetic_usa;
    }
   public String getParaphrase_en(){
       return paraphrase_en;
   }
   public void setParaphrase_en(String paraphrase_en){
       this.paraphrase_en=paraphrase_en;
   }
   public void getParaphrase_en(String paraphrase_en){
       this.paraphrase_en=paraphrase_en;
   }
   public String getParaphrase_zh(){
       return paraphrase_zh;
   }
   public void setParaphrase_zh(String paraphrase_zh){
       this.paraphrase_zh=paraphrase_zh;
   }
   public String getSample_sentence1(){
       return sample_sentence1;
   }
   public void setSample_sentence1(String sample_sentence1){
       this.sample_sentence1=sample_sentence1;
   }
   public String getSample_sentence2(){
       return sample_sentence2;
   }
   public void setSample_sentence2(String sample_sentence2){
        this.sample_sentence2=sample_sentence2;
    }
}