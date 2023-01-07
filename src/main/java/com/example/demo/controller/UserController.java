package com.example.demo.controller;



import com.example.demo.domain.Student;
import com.example.demo.mapper.UserMapper;

import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.util.Date;

import java.text.SimpleDateFormat;

import java.util.List;

@RestController
public class UserController {

    private Logger logger = LogManager.getLogger(LoginController.class);

    @Autowired
    private UserMapper userMapper;


    @RequestMapping("/showDao/{id}")

    public String GetUser(@PathVariable Integer id){

       return userMapper.Sel(id).toString();
    }

    /*@RequestMapping("/selectStudent")
    public List<Student> GetAll(){
        return userMapper.selectStudent();
    }*/
    @ResponseBody
    @GetMapping("/showStudent")
    public List<Student> GetAll(){
        logger.info("I get it!");
        return userMapper.showStudent();
    }
    //按id选择学生信息
    @RequestMapping("/selectStudent/{id}")
    public String Select(@PathVariable Integer id){
        logger.info("Select!");
        return userMapper.selectStudent(id).toString();
    }

    //使用对象添加学生信息
    @RequestMapping("/addStudent")
    public void Adds(@ModelAttribute Student student){
        logger.info(student.toString());
        Student student1 = new Student();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        logger.info(df.format(new Date()));
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setSex(student.getSex());
        student1.setid(student.getid());
        student1.setSetupTime(df.format(new Date()));
        student1.setUpdateTime(df.format(new Date()));
        userMapper.insertStudent(student1);
    }
    //删除学生信息
    @RequestMapping("/deleteStudent/{id}")
    public void Delete(@PathVariable Integer id){
        userMapper.deleteStudent(id);
        logger.info("Delete!");
    }

    //修改学生信息
    @RequestMapping("/updateStudent")
    public void Update(@ModelAttribute Student student){

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        student.setUpdateTime(df.format(new Date()));
        logger.info(student.toString());
        userMapper.updateStudent(student);
        logger.info("Update already!");
    }
}
