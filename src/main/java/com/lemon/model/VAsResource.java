package com.lemon.model;

import java.util.Date;

/**
 * Created by Wang Haobo on 2016/9/28.
 */
public class VAsResource {
    private int id;
    private String title;
    private String type;
    private String thumb;
    private String url;
    private String intro;
    private String srt_en;
    private String srt_zh;
    private Date date;



    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type=type;
    }
    public String getThumb(){
        return thumb;
    }
    public void setThumb(String thumb){
        this.thumb=thumb;
    }
    public String getSource_path(){
        return url;
    }
    public void setSource_path(String url){
        this.url=url;
    }
    public String getIntro(){
        return intro;
    }
    public  void setIntro(String intro){
        this.intro=intro;
    }
    public String getSrt_en(){
        return srt_en;
    }
    public void setSrt_en(String srt_en){
        this.srt_en=srt_en;
    }
    public String getSrt_zh(){
        return srt_zh;
    }
    public void setSrt_zh(String srt_zh){
        this.srt_zh=srt_zh;
    }
    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date=date;
    }
}
