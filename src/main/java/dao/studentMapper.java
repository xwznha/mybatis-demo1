package dao;

import entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface studentMapper {
    int insertStudent(@Param("student")Student student);
    int deleteStudent(String stuNum);

    Student selectStuentById(String id);

    List<Student> selectStuentByName(@Param("name") String name);
}
