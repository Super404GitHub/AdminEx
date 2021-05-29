package com.atguigu.admin.controller;

import com.atguigu.admin.bean.Bean;
import com.atguigu.admin.bean.User;
import com.atguigu.admin.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String basicTable(){
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value="pn",defaultValue = "1") Integer pn,
                                Model model){
        //表格内容的遍历

        //从数据库中查出user表中的用户进行展示

        //构造分页参数
        Page<User> page = new Page<>(pn, 5);
        //调用page进行分页
        Page<User> userPage = userService.page(page, null);

        model.addAttribute("users",userPage);

        return "table/dynamic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id")Long id,
                             @RequestParam(value="pn",defaultValue="1")Integer pn,
                             RedirectAttributes ra){
        userService.removeById(id);
        // RedirectAttributes:可以使重定向携带参数
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsiveTable(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editableTable(){
        return "table/editable_table";
    }

    @GetMapping("/pricing_table")
    public String pricingTable(){
        return "table/pricing_table";
    }
}
