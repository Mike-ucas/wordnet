package com.lemon.controller;

/**
 * Created by Wang Haobo on 2016/9/4.
 */

import com.lemon.tools.DatabaseConnection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@Controller
//@WebServlet(name="login", urlPatterns={"/login"})
public class LoginServlet extends HttpServlet {

    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String errMsg = "";
        RequestDispatcher rd;
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        try {
            Connection conn = DatabaseConnection.getInitConn().getConnection();
            PreparedStatement pst = conn.prepareStatement("select password from user_login where id = ?");
            pst.setObject(1, id);
            // 查询结果集
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                //用户名和密码匹配
                if (rs.getString("password").equals(password)) {
                    //获取session对象
                    HttpSession session = request.getSession(true);
                    session.setAttribute("id", id);

                    //获取转发对象
                    rd = request.getRequestDispatcher("/welcome.jsp");

                    // 转发请求
                    rd.forward(request, response);
                } else {
                    errMsg += "您的用户名密码不匹配，请重新输入";
                }
            } else {
                errMsg += "您的用户名不存在，请先注册";
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 如果出错，转发到重新登陆
        if (errMsg != null && !errMsg.equals("")) {
            rd = request.getRequestDispatcher("/login.jsp");
            request.setAttribute("err", errMsg);
            rd.forward(request, response);
        }
    }
}
