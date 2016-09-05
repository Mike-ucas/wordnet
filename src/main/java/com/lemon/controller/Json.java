package com.lemon.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wang Haobo on 2016/9/5.
 */

//@WebServlet(name="Json", urlPatterns={"/json"})
public class Json extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/json.jsp");
        rd.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/xml;character=utf-8");
        response.setHeader("Cache-Control", "no-cache");
        try {
            //创建Person对象，保存数据，如果有数据库的话，此处数据应该为从数据库中取出
            Person p = new Person();
            p.setName("first");
            p.setId(1);
            p.setPwd("123456");
            Person p1 = new Person();
            p1.setName("second");
            p1.setId(2);
            p1.setPwd("666888");
            //将Person对象装入集合
            List<Person> list = new ArrayList<Person>();
            list.add(p);
            list.add(p1);
            try {
                //创建JsonArray对象，JSONArray则是[]包裹起来的一个数组(Array)，此处调用方法将对象集合装入
                JSONArray json = JSONArray.fromObject(list);
                //JSONObject是一个{}包裹起来的一个对象(Object)，此处希望以对象为单位进行操作，所以创建JSONObject对象
                JSONObject jb = new JSONObject();
                //将jsonArray对象装入
                jb.put("person", json);
                //输出Json数据，它就是一种特殊格式的字符串
                response.getWriter().write(jb.toString());

				/*此处可以用另一种方式将数据装入Json,同样可以,只是前台接受的是JSONArray对象，是[]包裹起来的一个数组(Array)
				 *JSONArray jsonArray = new JSONArray();
				 *JSONObject jb = new JSONObject();
				 *jb.put("person", json);
				 *jsonArray.add(jb);
				 *response.getWriter().write(jsonArray.toString());
				 */

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}