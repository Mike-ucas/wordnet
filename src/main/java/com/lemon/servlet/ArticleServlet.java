package com.lemon.servlet;

import com.lemon.model.Article;
import com.lemon.tools.DatabaseConnection;
import com.lemon.tools.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Wang Haobo on 2016/9/28.
 */
@WebServlet(name = "ArticleServlet", urlPatterns="/article")
public class ArticleServlet extends HttpServlet {
        public void service(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            //输出Json数据，它就是一种特殊格式的字符串
            JSONObject jsonObject = new JSONObject();
            //String id = request.getParameter("id");
            // System.out.println(id);
            // String password = request.getParameter("password");
            // System.out.println(password);
            try {
                Connection conn = DatabaseConnection.getInitConn().getConnection();
                PreparedStatement pst = conn.prepareStatement("select * from article");
                //pst.setObject(1, id);
                // 查询结果集
                ResultSet rs = pst.executeQuery();
                List<Article> list = new ArrayList<Article>();
                while(rs.next()) {
                    Article article = new Article();
                    article.setId(rs.getInt("id"));
                    article.setTitle(rs.getString("title"));
                    article.setAuthor(rs.getString("author"));
                    article.setContent(rs.getString("content"));
                    article.setDate(rs.getDate("date"));
                    list.add(article);
                }
                JsonConfig jsonConfig = new JsonConfig();
                jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());
                //创建JsonArray对象，JSONArray则是[]包裹起来的一个数组(Array)，此处调用方法将对象集合装入
                JSONArray json = JSONArray.fromObject(list,jsonConfig);
                //JSONObject是一个{}包裹起来的一个对象(Object)，此处希望以对象为单位进行操作，所以创建JSONObject对象
                // 将jsonArray对象装入
                jsonObject.put("Article", json);
                response.getWriter().write(jsonObject.toString());
                System.out.println("article传递参数成功");
            }catch(Exception ex) {
                ex.printStackTrace();
            }
        }
}
