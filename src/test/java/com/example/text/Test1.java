package com.example.text;


import com.example.Dao.IUserDao;
import com.example.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis的入门案例
 */
public class Test1 {
    public static void main(String[] args) {
        //1.读取配置文件
        InputStream resource = null;
        SqlSession sqlSession = null;
        try {
            resource = Resources.getResourceAsStream("SqlMapConfig.xml");
            //2.创建SqlSessionFactory工厂实例
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resource);
            //3.用工厂实例创建SqlSession实例
            sqlSession = sessionFactory.openSession();
            //4.使用SqlSession实例创建IUserDao的代理对象
            IUserDao userDao = sqlSession.getMapper(IUserDao.class);
            //5.使用代理对象执行方法
            List<User> users = userDao.findAll();
            for (User user : users) {
                System.out.println(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            //6.释放资源
            try {
                resource.close();
                sqlSession.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
