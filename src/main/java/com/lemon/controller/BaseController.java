package com.lemon.controller;

/**
 * Created by Wang Haobo on 2016/9/3.
 */

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
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Administrator on 15-1-31.
 */
/*There must be a Controller annotation or the application will doesn't work .*/
@Controller
public class BaseController {
    private static int counter=0;
    private static final String VIEW_INDEX="index";
    private static final Logger logger= LoggerFactory.getLogger(BaseController.class);




    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public String welcome(ModelMap model) throws SQLException {
        String sql_temp="select * from wordnet.user_login";
        // JSON格式数据解析对象
        JSONObject json_obj = new JSONObject();
        Connection conn=null;
        PreparedStatement pst =  null;
        ResultSet rs =null;
        try{
            conn= DatabaseConnection.getInitConn().getConnection();
            pst=conn.prepareStatement(sql_temp);
            rs=pst.executeQuery();
            //create Json here.Data
            System.out.println(rs.next());
            Map<String, String> map1 = new HashMap<String, String>();
            //while(rs.next()){
            map1.put("id", rs.getString("id"));
            map1.put("password", rs.getString("password"));
            map1.put("category", rs.getString("category"));
            // 将Map转换为JSONArray数据
            JSONArray ja1 = JSONArray.fromObject(map1);
            json_obj.put("user_login",ja1);
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        model.addAttribute("user",json_obj);
        model.addAttribute("message","Welcome");
        model.addAttribute("counter",++counter);
        logger.debug("[Welcome counter :{}",counter);
        return VIEW_INDEX;//返回index.jsp
    }

//    @RequestMapping(value = "/{name}" ,method = RequestMethod.GET)
//    public String welcome(@PathVariable String name , ModelMap model){
//        model.addAttribute("message","Welcome "+name);
//        model.addAttribute("counter",++counter);
//        logger.debug("[Welcome counter :{}",counter);
//        return VIEW_INDEX;//返回index.jsp
//    }
}
