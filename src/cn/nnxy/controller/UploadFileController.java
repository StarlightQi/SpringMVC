package cn.nnxy.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.nnxy.model.ResponseData;
import cn.nnxy.model.User;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.BASE64Decoder;

@Controller
public class UploadFileController {

    /**
     * 单文件上传
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData register(String base64, String userName, String email, String password, HttpServletRequest request, HttpSession session) throws IOException {
        String path = request.getServletContext().getRealPath("/image/");
        String s = BASE64DecodedMultipartFile.saveBase64(base64, path);
        User user = new User(email, userName, password, s).register();
        if (user != null) {
            session.setAttribute("name",user.getEmail());
            session.setAttribute("password",user.getPassWord());
            return new ResponseData(true, "注册成功", null);
        }
        return new ResponseData(false, "注册失败，可能是用户名邮箱重复了！----该数据用于测试用", null);
    }

    @RequestMapping("/login")
    @ResponseBody
    public ResponseData login(String email,String password, HttpSession session) throws IOException {
        User user=new User(email,password).getLoginUser();
        if (user!=null) {
            session.setAttribute("name",user.getEmail());
            session.setAttribute("password",user.getPassWord());
            return new ResponseData(true,"登录成功",null);
        }
        return new ResponseData(false,"账号和密码错误",null);
    }

    @RequestMapping("/getUserInfo.do")
    public ModelAndView getUserInfo(HttpSession session) throws IOException {
        ModelAndView view=new ModelAndView();
        User user= new User((String)session.getAttribute("name"),(String)session.getAttribute("password")).getLoginUser();
        view.addObject("user",user);
        view.setViewName("userInfo");
        return view;
    }
    /**
     * 多文件上传
     */
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public String updateUserInfo(@RequestParam MultipartFile[] files, HttpServletRequest request,HttpSession session) throws IOException {
        MultipartFile file1 = files[0];
        MultipartFile file2 = files[1];
        User user= new User((String)session.getAttribute("name"),(String)session.getAttribute("password"));
        String path = request.getServletContext().getRealPath("/image/");
        String name1=BASE64DecodedMultipartFile.saveOneFile(file1, path);
        String name2=BASE64DecodedMultipartFile.saveOneFile(file2, path);
        request.setAttribute("user",user.getLoginUser());
        user.updateUserInfo(name1,name2);
        return "userInfo";
    }


}
