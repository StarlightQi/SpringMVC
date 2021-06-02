package com.nnxy.testController;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MySpringMVCWork {
    @RequestMapping("/login")
    public ModelAndView login(String number, String yzm, String pwd, String psw, MultipartFile attach, @RequestParam MultipartFile[] attachs, HttpServletRequest request) {
        System.out.println("login...");
        System.out.println("number:" + number);
        System.out.println("yzm:" + yzm);
        System.out.println("password:" + pwd);
        System.out.println("password2:" + psw);
        ModelAndView modelAndView = new ModelAndView();

        String zhen = saveOneFile(attachs[0], request);// 身份证正面
        String fan = saveOneFile(attachs[1], request);// 身份证反面


        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("number", number);
        userInfo.put("yzm", yzm);
        userInfo.put("pwd", pwd);
        userInfo.put("psw", psw);
        userInfo.put("zhen", zhen);
        userInfo.put("fan", fan);

        String s = saveOneFile(attach, request);
        System.out.println("------------------");
        System.out.println(s);
        userInfo.put("path", s);
        modelAndView.addAllObjects(userInfo);

        //3.设置响应页面
        modelAndView.setViewName("userInfo");

        //4.返回modelAndView对象
        return modelAndView;
    }

    public String saveOneFile(MultipartFile attach, HttpServletRequest request) {
        System.out.println("saveOneFile()....");

        // 获取服务器存放上传文件的文件夹路径
        String path = request.getSession().getServletContext().getRealPath("/image");
        System.out.println("path:" + path);

        // 获取上传文件的文件名（原文件名）
        String oldFileName = attach.getOriginalFilename();
        System.out.println("oldFileName:" + oldFileName);

        // 新文件名
        String newFileName = "";

        // //方式一：新文件名，与原文件名相同
        // newFileName = oldFileName;

        // //方式二：新文件名 =
        // 文件名的前缀
        String prefix = FilenameUtils.getBaseName(oldFileName);

        // 文件名的后缀
        String suffix = FilenameUtils.getExtension(oldFileName);

        // 新文件名= 前缀 + "-" + 当前系统时间 + "-" + 随机数 + "." + 后缀
        newFileName = prefix + "-" + System.currentTimeMillis() + "-" + RandomUtils.nextInt(1000000) + "." + suffix;

        // 创建文件（全路径名）
        File targetFile = new File(path, newFileName);

        // 如果文件（夹）不存在，则创建
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        try {
            // 向文件中写入数据
            attach.transferTo(targetFile);
            request.setAttribute("fileUploadResult", "* 上传文件成功！");

        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("fileUploadResult", "* 上传文件失败！");
        }

        return newFileName;
    }

}
