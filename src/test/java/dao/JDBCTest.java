package dao;

import entity.Student;

import java.sql.*;

public class JDBCTest {

    @org.junit.Test
    public void test() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.创建连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fmmall2?characterEncoding=utf-8&useSSL=false","root","123456");
            // 3.SQL语句
            String sql = "select * from tb_students where sid = ?";
            // 4.获得sql执行者
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,1);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();

            while(rs.next()){
                Student student = new Student();
                student.setStuId(rs.getInt("sid"));
                student.setStuNum(rs.getString("stu_num"));
                student.setStuAge(rs.getInt("stu_age"));
                student.setStuGender(rs.getString("stu_gender"));
                student.setStuName(rs.getString("stu_name"));
                System.out.println(student);
            };

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }







}
