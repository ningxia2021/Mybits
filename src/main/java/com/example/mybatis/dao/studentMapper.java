package com.example.mybatis.dao;

import com.example.mybatis.model.students;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface studentMapper {
    void addStudent(students student);

    List<students> selectById(int id);

    List<students> selectByName(String name);

    int updateName(students s);
    int updateByName(String name,int id); //当有两个参数时，要么传对象，要么不要设置parameterType

    int delById(int id);
}
