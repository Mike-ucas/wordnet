package com.lemon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by Wang Haobo on 2016/9/26.
 */
@Controller
public class UploadController {
    //注意：这个的路径不要写成“/upload”，否则会有一个意向不到的错误。
    @RequestMapping(value = "/uploadvideo", method = RequestMethod.POST)
    public String uploadvideo(
            @RequestParam(value = "video", required = false) MultipartFile video,
            @RequestParam(value = "videotype", required = false) String videotype,
            @RequestParam(value = "srt", required = false) MultipartFile srt,
            HttpServletRequest request, ModelMap model) {
        System.out.println("开始");
        //创建你要保存的文件的路径
        String path = request.getSession().getServletContext().getRealPath("video")+"\\"+videotype;
        //获取该文件的文件名
        String videoName = video.getOriginalFilename();
        String srtName = srt.getOriginalFilename();

        System.out.println(path);
        File targetFile = new File(path, videoName);
        File targetFile1 = new File(path, srtName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        if (!targetFile1.exists()) {
            targetFile1.mkdirs();
        }
        // 保存
        try {
            video.transferTo(targetFile);
            srt.transferTo(targetFile1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将该文件的路径给客户端，让其可以请求该图片
        model.addAttribute("fileUrl", request.getContextPath() + "/video/"+ videotype + "/" + videoName);
        return "result";
    }
}

