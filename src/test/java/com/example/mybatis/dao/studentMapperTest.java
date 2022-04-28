package com.example.mybatis.dao;

import com.example.mybatis.model.students;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONUtil;
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
        students.setId(10);
        students.setName("今天是2022");
        students.setAge(23);
        students.setSec("又要被封了");
        studentMapper.addStudent(students);
    }

    @Test
    void selectById() {
        List<students> students = studentMapper.selectById(10);
        for (students a : students){
            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println(a.toString());
            System.out.println("--------------------------------------");
            System.out.println();
        }
    }

    @Test
    void selectByName() {
        List<students> students = studentMapper.selectByName("西安人的城墙下");
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println(students.toString());
        System.out.println("--------------------------------------");
        System.out.println();
    }

    @Test
    void updateName() {
        students s = new students();
        s.setName("gaoh");
        s.setId(10);
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println(" SQL 改动的行数为 :"+studentMapper.updateName(s));
        System.out.println(studentMapper.selectById(10));
        System.out.println("----------------------------------------");
        System.out.println();
    }

    @Test
    void delById() {
        studentMapper.delById(10);
    }

    @Test
    void updateByName() {
        int ret = studentMapper.updateByName("hah", 6);
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println(ret);
        System.out.println(studentMapper.selectById(6));
        System.out.println("----------------------------------------");
        System.out.println();
    }

    @Test
    void selectAllById() {
        List<students> desc = studentMapper.selectAllById("desc");
//        for (students s:desc) {
//            System.out.println();
//            System.out.println(s);
//        }
        desc.forEach(System.out::println);
    }
}