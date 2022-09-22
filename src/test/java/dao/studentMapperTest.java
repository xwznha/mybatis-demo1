package dao;

import entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class studentMapperTest {
    @org.junit.Test
    public void selectStudent() {
        // 加载mybatis配置⽂件
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            // 会话⼯⼚
            SqlSessionFactory factory = builder.build(is);
            // 会话（连接）
            SqlSession sqlSession = factory.openSession();
            // 通过会话获取DAO对象
            studentMapper studentMapper = sqlSession.getMapper(studentMapper.class);
            // 测试StudentDAO中的⽅法
            // Student student = studentMapper.selectStuentById("5");
            List<Student> students = studentMapper.selectStuentByName("张三");
            //需要⼿动提交
            sqlSession.commit();
            System.out.println(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void insertStudent() {
        //加载mybatis配置⽂件
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //会话⼯⼚
            SqlSessionFactory factory = builder.build(is);
            //会话（连接）
            SqlSession sqlSession = factory.openSession();
            //通过会话获取DAO对象
            studentMapper studentMapper = sqlSession.getMapper(studentMapper.class);
            //测试StudentDAO中的⽅法
            int i = studentMapper.insertStudent(new Student(0, "10003", "张三", "男", 21));
            //需要⼿动提交
            sqlSession.commit();
            System.out.println(i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void deleteStudent() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //会话⼯⼚
            SqlSessionFactory factory = builder.build(is);
            //会话（连接）
            SqlSession sqlSession = factory.openSession();
            //通过会话获取DAO对象
            studentMapper studentMapper = sqlSession.getMapper(studentMapper.class);
            //测试StudentDAO中的⽅法
            int i = studentMapper.deleteStudent("10001");
            //需要手动提交
            sqlSession.commit();
            System.out.println(i);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}