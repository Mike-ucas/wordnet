package com.lemon.controller;

/**
 * Created by Wang Haobo on 2016/9/3.
 */

import com.lemon.dao.UserLogin;
import com.lemon.tools.DatabaseConnection;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 15-1-31.
 */
/*There must be a Controller annotation or the application will doesn't work .*/
@Controller
public class BaseController {
    private static final String VIEW_INDEX="index";
    private static final Logger logger= LoggerFactory.getLogger(BaseController.class);




    @RequestMapping(value = "/json1" ,method = RequestMethod.GET)
    public String json(ModelMap model) throws SQLException {
        // JSON格式数据解析对象
        JSONObject json_obj = new JSONObject();

        try{
            Connection conn= DatabaseConnection.getInitConn().getConnection();
            String sql_temp="select * from wordnet.user_login ";
            PreparedStatement pst=conn.prepareStatement(sql_temp);
            ResultSet rs=pst.executeQuery();
           //System.out.println(rs.next());
            List<UserLogin> list = new ArrayList<UserLogin>();
            while(rs.next()) {
                UserLogin user = new UserLogin();
                user.setId(rs.getString("id"));
                //System.out.println(rs.getString("id"));
                user.setPassword(rs.getString("password"));
               // user.setCategory(rs.getString("category"));
                list.add(user);
            }
            //创建JsonArray对象，JSONArray则是[]包裹起来的一个数组(Array)，此处调用方法将对象集合装入
            JSONArray json = JSONArray.fromObject(list);
            //JSONObject是一个{}包裹起来的一个对象(Object)，此处希望以对象为单位进行操作，所以创建JSONObject对象
            //将jsonArray对象装入
            json_obj.put("user_login", json);

            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        model.addAttribute("user",json_obj);
        return VIEW_INDEX;//返回index.jsp
    }

    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public String welcome(){
        return "login";//返回login.jsp
    }
    @RequestMapping(value = "/json" ,method = RequestMethod.GET)
    public String test(){
        return "json";//返回test.jsp
    }

    @RequestMapping(value = "/upload" ,method = RequestMethod.GET)
    public String upload(){
        return "upload";//返回upload.jsp
    }
}
