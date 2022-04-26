package com.example.mybatis.dao;

import com.example.mybatis.model.students;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional //正常测试功能 但是不污染数据库
@Slf4j
class studentMapperTest {

//    注入实例
    @Autowired
    private studentMapper studentMapper;

    @Test
    void addStudent() {
        students students = new students();
        students.setId(5);
        students.setName("西安人不管到哪儿");
        students.setAge(23);
        students.setSec("都不能不吃泡馍");
        int s = studentMapper.addStudent(students);
        System.out.println("这是结果返回 : "+s);
    }

    @Test
    void selectById() {
        List<students> students = studentMapper.selectById(5);
        for (students a : students){
            System.out.println(a.toString());
        }
    }


//    @Test
//    void selectStudent() {
//        List<students> students = studentMapper.selectStudent();
//        for (com.example.mybatis.model.students a : students){
//            System.out.println(a.toString());
//        }
//    }
}