package com.example.mybatis.dao;

import com.example.mybatis.model.students;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface studentMapper {
    public int addStudent(students student);

    public List<students> selectById(int id);
}
