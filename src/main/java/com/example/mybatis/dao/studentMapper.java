package com.example.mybatis.dao;

import com.example.mybatis.model.students;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface studentMapper {
    public void addStudent(students student);

    public List<students> selectById(int id);

    public List<students> selectByName(String name);
}
