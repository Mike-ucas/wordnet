package com.lemon.servlet;

import com.lemon.model.VAsResource;
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
@WebServlet(name = "VideoServlet",urlPatterns = "/video")
public class VideoServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //输出Json数据，它就是一种特殊格式的字符串
        JSONObject jsonObject = new JSONObject();
        response.setContentType("application/json;charset=UTF-8");//防止数据传递乱码
        try {
            Connection conn = DatabaseConnection.getInitConn().getConnection();
            PreparedStatement pst = conn.prepareStatement("select * from vas_resource");
            //pst.setObject(1, id);
            // 查询结果集
            ResultSet rs = pst.executeQuery();
            List<VAsResource> list = new ArrayList<VAsResource>();
            while(rs.next()) {
                VAsResource vasRes= new VAsResource();
                vasRes.setId(rs.getInt("id"));
                vasRes.setTitle(rs.getString("title"));
                vasRes.setType(rs.getString("type"));
                vasRes.setThumb(rs.getString("thumb"));
                vasRes.setSource_path(rs.getString("url"));
                vasRes.setIntro(rs.getString("intro"));
                vasRes.setSrt_en(rs.getString("srt_en"));
                vasRes.setSrt_zh(rs.getString("srt_zh"));
                vasRes.setDate(rs.getDate("date"));
                list.add(vasRes);
            }
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());
            //创建JsonArray对象，JSONArray则是[]包裹起来的一个数组(Array)，此处调用方法将对象集合装入
            JSONArray json = JSONArray.fromObject(list,jsonConfig);
            //JSONObject是一个{}包裹起来的一个对象(Object)，此处希望以对象为单位进行操作，所以创建JSONObject对象
            // 将jsonArray对象装入
            jsonObject.put("Video", json);
            response.getWriter().write(jsonObject.toString());
            System.out.println("Video传递参数成功");
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
