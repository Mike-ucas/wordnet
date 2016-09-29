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

/**
 * Created by Wang Haobo on 2016/9/29.
 */
@WebServlet(name = "VideoLogServlet",urlPatterns = "/videolog")
public class VideoLogServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //输出Json数据，它就是一种特殊格式的字符串
        JSONObject jsonObject = new JSONObject();
        String user_id = request.getParameter("userid");
        String video_id = request.getParameter("videoid");
        try{
            if(user_id == null|| video_id == null ){
                jsonObject.put("message", "failed");
                jsonObject.put("status", "false");
            }else{
                Connection conn = DatabaseConnection.getInitConn().getConnection();
                PreparedStatement pst = conn.prepareStatement("insert into video_log(user_id,video_id) values(?,?)");
                pst.setObject(1, user_id);
                pst.setObject(2, video_id);
                // 查询结果集
                int addColumn = pst.executeUpdate();
                if (addColumn == 0) {
                    // 失败
                    jsonObject.put("message", "failed");
                    jsonObject.put("status", "false");
                }else{
                    // 成功
                    jsonObject.put("message", "success");
                    jsonObject.put("status", "true");
                }
                conn.close();
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        response.getWriter().write(jsonObject.toString());
    }
}
