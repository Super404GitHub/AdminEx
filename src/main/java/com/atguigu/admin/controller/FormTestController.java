package com.atguigu.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 文件上传测试
 */
@Controller
public class FormTestController {

//    @GetMapping("/form_layout")
//    public String form_layouts(){
//        return "form/form_layouts";
//    }

    @GetMapping("/form_layout")
    public String form_layouts(){
        return "form/form_layouts";
    }


    /**
     * 文件上传请求处理
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email")String email,
                         @RequestParam("username")String username,
                         @RequestPart("headerImg")MultipartFile headerImg,
                         @RequestPart("photos")MultipartFile[] photos)throws Exception{
        if (!headerImg.isEmpty()){
            //保存到磁盘中
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("D:\\WebSoft\\"+originalFilename));
        }
        if (photos.length>0){
            for (MultipartFile photo:photos){
                if (!photo.isEmpty()){
                    String filename = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\WebSoft\\"+filename));
                }
            }
        }
        return "main";
    }


















}
