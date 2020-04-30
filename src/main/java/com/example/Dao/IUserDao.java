package com.example.Dao;
import com.example.domain.User;


import java.util.List;


/**
 * 用户的持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有操作
     */
    List<User> findAll();
}
