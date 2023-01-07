package com.example.demo.controller;

import com.example.demo.domain.Score;
import com.example.demo.mapper.UserMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ScoreController {
    @Autowired
    private UserMapper userMapper;
    private Logger logger = LogManager.getLogger(LoginController.class);

    //显示所有信息
    @RequestMapping("/showScore")
    public List<Score> GetAll(){
        return userMapper.showScore();
    }

    //删除学生成绩信息
    @RequestMapping("/deleteScore/{id}")
    public void Delete(@PathVariable Integer id){
        userMapper.deleteScore(id);
        logger.info("Delete!");
    }

    //显示单个学生成绩信息
    @RequestMapping("/selectScore/{id}")
    public String Select(@PathVariable Integer id){
        logger.info("Select!");
        return userMapper.selectScore(id).toString();
    }

    //添加信息
    @RequestMapping("/addScore")
    public void Adds(@ModelAttribute Score score){
        logger.info(score.toString());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        logger.info(df.format(new Date()));
        score.setSetupTime(df.format(new Date()));
        score.setUpdateTime(df.format(new Date()));
        userMapper.insertScore(score);
    }

    //更新信息
    @RequestMapping("/updateScore")
    public void Update(@ModelAttribute Score score){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        score.setUpdateTime(df.format(new Date()));
        logger.info(score.toString());
        userMapper.updateScore(score);
        logger.info("Update already!");
    }

}
