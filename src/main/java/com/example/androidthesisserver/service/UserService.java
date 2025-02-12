package com.example.androidthesisserver.service;

import com.example.androidthesisserver.entity.User;
import com.example.androidthesisserver.entity.UserEdit;
import com.example.androidthesisserver.mapper.UserEditMapper;
import com.example.androidthesisserver.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
public class UserService {

    private final UserMapper userMapper;
    private final UserEditMapper userEditMapper;

    @Autowired
    public UserService(UserMapper userMapper, UserEditMapper userEditMapper) {
        this.userMapper = userMapper;
        this.userEditMapper = userEditMapper;
    }



    /**
     * 根据邮箱查找用户
     * @param email 用户邮箱
     * @return 用户对象，如果没有找到，返回null
     */
    public User findUserByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    public User findUserById(Long id){return userMapper.findById(id);}

    /**
     * 注册用户
     * @param email 用户邮箱
     */
    @Transactional
    public void registerUser(String email) {
        // 1. 创建用户并插入到 users 表
        User user = new User();
        user.setEmail(email);
        user.setIsFirstLogin(true);  // 假设是第一次登录
        // 1. 插入 users 表
        userMapper.insertUser(user); // 插入 user 后，user 对象中会自动填充 user_id（假设是自增的）

        // 2. 获取生成的 user_id
        Long userId = user.getId(); // 获取插入后的 user_id

        // 3. 如果 user_id 不为空，则插入 user_edit 表
        if (userId != null) {
            UserEdit userEdit = new UserEdit();
            userEdit.setId(userId);  // 将生成的 user_id 设置到 user_edit 中
            userEditMapper.insertUserEdit(userEdit);  // 插入 user_edit 表

        } else {
            throw new RuntimeException("User ID is null, failed to insert UserEdit.");
        }
    }
    /**
     * 更新用户登录状态
     * @param email 用户邮箱
     */
    public void updateLoginStatus(String email) {
        userMapper.updateLoginStatus(email);
    }
}