package com.lemon.model;

import java.util.Date;

/**
 * Created by Wang Haobo on 2016/9/27.
 */
public class UserProfile {
    private String id;
    private String name;
    private String gender;
    private String phone;
    private Date  birthday;
    private String major;

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }

    public String getMajor(){
        return major;
    }
    public void setMajor(String major){
        this.major=major;
    }
    public Date getBirthday(){
        return birthday;
    }
    public void setBirthday(Date birthday){
        this.birthday=birthday;
    }
}
