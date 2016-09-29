package com.lemon.servlet;

import com.lemon.tools.DatabaseConnection;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Wang Haobo on 2016/9/27.
 */

@WebServlet(name="authenticateServlet", urlPatterns={"/authenticate"})
public class AuthenticateServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //输出Json数据，它就是一种特殊格式的字符串
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id");
        System.out.println(id);
        String password = request.getParameter("password");
        System.out.println(password);
        try{
            Connection conn = DatabaseConnection.getInitConn().getConnection();
            PreparedStatement pst = conn.prepareStatement("select password from user_login where id = ?");
            pst.setObject(1,id);
            // 查询结果集
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                //用户名和密码匹配
                if (rs.getString("password").equals(password)) {
                    jsonObject.put("message", "success");
                    jsonObject.put("status", "true");
                } else {
                    jsonObject.put("message", "failed");
                    jsonObject.put("status", "false");
                }
            }else {
                jsonObject.put("message", "failed");
                jsonObject.put("status", "false");
            }
            conn.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        response.getWriter().write(jsonObject.toString());
    }
}
