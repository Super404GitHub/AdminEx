package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class indexController {

    /**
     * 来到登录页
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if(user.getUsername().length()!=0&&"123456".equals(user.getPassword())){
           //保存登录用户的信息
            session.setAttribute("loginUser",user);
            //登陆成功，然后重定向到main页面---防止表单重复提交
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误!");
            return "/login";
        }

    }

    @GetMapping("/main.html")
    public String mainPae(HttpSession session,Model model){
//        User user = (User) session.getAttribute("loginUser");
//        if(user!=null){
//            return "main";
//        }else{
//            model.addAttribute("msg","请重新登录!");
//            return "/login";
//        }

        return "main";
    }



















}
