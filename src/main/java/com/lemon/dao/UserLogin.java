package com.lemon.dao;

/**
 * Created by Wang Haobo on 2016/9/26.
 */
public class UserLogin {

    private String id;
    private String password;
    //private String category;
    public UserLogin(){}
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    /*public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category=category;
    }*/
}
