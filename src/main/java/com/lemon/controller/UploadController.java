package com.lemon.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by Wang Haobo on 2016/9/26.
 @Controller
 */
public class UploadController {
    //注意：这个的路径不要写成“/upload”，否则会有一个意向不到的错误。
    @RequestMapping(value = "/saveuploads", method = RequestMethod.POST)
    public String upload(
            @RequestParam(value = "file", required = false) MultipartFile file,
            HttpServletRequest request, ModelMap model) {
        System.out.println("开始");
        //创建你要保存的文件的路径
        String path = request.getSession().getServletContext().getRealPath("lupload");
        //获取该文件的文件名
        String fileName = file.getOriginalFilename();

        System.out.println(path);
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        // 保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将该文件的路径给客户端，让其可以请求该图片
        model.addAttribute("fileUrl", request.getContextPath() + "/lupload/"+ fileName);
        return "result";
    }
}

