package com.example.demo.controller;


import com.example.demo.domain.Score;
import com.example.demo.domain.Student;
import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    private Logger logger = LogManager.getLogger(LoginController.class);
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user",new User());
        logger.info("登陆成功！");
        return "login";
    }

    @PostMapping("/login")
    public String submit(@ModelAttribute User user, Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(user.getUsername())&&"123456".equals(user.getPassword())){
            session.setAttribute("loginUser",user.getUsername());
            return "main";
        }else{
            map.put("msg","用户名密码错误");
            return "redirect:/login";
        }
    }

    @GetMapping("/s")
    public String main(Model model){

        logger.info("进入主页面！");
        return "main";
    }

    @RequestMapping("/wel")
    public String head(){
        logger.info("------------>head.html------------>"+new Date());
        return "wel";
    }

    @GetMapping("/stu_m")
    public String showStudent(Model model){
        model.addAttribute("student",new Student());
        logger.info("------------>stu_m.html------------>"+new Date());
        return"stu_m";
    }

    @GetMapping("/sco_m")
    public String showScore(Model model){
        model.addAttribute("score",new Score());
        logger.info("------------>sco_m.html------------>"+new Date());
        return"sco_m";
    }

    @GetMapping("/cou_m")
    public String showCourse(){
        logger.info("------------>cou_m.html------------>"+new Date());
        return"cou_m";
    }

}
