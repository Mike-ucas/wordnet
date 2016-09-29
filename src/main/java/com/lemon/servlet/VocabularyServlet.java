package com.lemon.servlet;

import com.lemon.model.Vocabulary;
import com.lemon.tools.DatabaseConnection;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
import java.util.List;

/**
 * Created by Wang Haobo on 2016/9/28.
 */
@WebServlet(name = "VocabularyServlet",urlPatterns = "/words")
public class VocabularyServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //输出Json数据，它就是一种特殊格式的字符串
        JSONObject jsonObject = new JSONObject();
        try {
            Connection conn = DatabaseConnection.getInitConn().getConnection();
            PreparedStatement pst = conn.prepareStatement("select * from vocabulary");
            //pst.setObject(1, id);
            // 查询结果集
            ResultSet rs = pst.executeQuery();
            List<Vocabulary> list = new ArrayList<Vocabulary>();
            Vocabulary voc = new Vocabulary();
            while(rs.next()) {
                voc.setId(rs.getInt("id"));
                voc.setWord(rs.getString("word"));
                voc.setUnit(rs.getInt("unit"));
                voc.setPhonetic_uk(rs.getString("phonetic_uk"));
                voc.setPhonetic_usa(rs.getString("phonetic_usa"));
                voc.setParaphrase_zh(rs.getString("paraphrase_zh"));
                voc.setParaphrase_en(rs.getString("paraphrase_en"));
                voc.setSample_sentence1(rs.getString("sample_sentence1"));
                voc.setSample_sentence2(rs.getString("sample_sentence2"));
                list.add(voc);
            }
            //创建JsonArray对象，JSONArray则是[]包裹起来的一个数组(Array)，此处调用方法将对象集合装入
            JSONArray json = JSONArray.fromObject(list);
            //JSONObject是一个{}包裹起来的一个对象(Object)，此处希望以对象为单位进行操作，所以创建JSONObject对象
            // 将jsonArray对象装入
            jsonObject.put("Words", json);
            response.getWriter().write(jsonObject.toString());
            System.out.println("Words传递参数成功");
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
