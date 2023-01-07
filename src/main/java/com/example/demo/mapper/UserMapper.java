package com.example.demo.mapper;

import com.example.demo.domain.Score;
import com.example.demo.domain.Student;
import com.example.demo.domain.User;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    //查找id
    User Sel(Integer id);

   //搜索单个学生信息
    List<Student> selectStudent(Integer id);

    //显示所有学生信息
    List<Student> showStudent();

    //修改学生信息
    void updateStudent(Student student);

    //新增学生信息
    void insertStudent(Student student);

    //删除学生信息
    void deleteStudent(Integer id);

    //查找所有学生的成绩信息
    List<Score> showScore();

    //查找单个学生信息
    Score selectScore(Integer id);

    //删除学生成绩信息
    void deleteScore(Integer id);

    //添加学生成绩信息
    void insertScore(Score score);

    //更新学生成绩信息
    void updateScore(Score score);
}
