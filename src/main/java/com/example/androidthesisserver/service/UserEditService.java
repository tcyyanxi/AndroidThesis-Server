package com.example.androidthesisserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.androidthesisserver.entity.UserEdit;
import com.example.androidthesisserver.mapper.UserEditMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEditService {

    @Autowired
    private UserEditMapper userEditMapper;

    public UserEdit getUserEditById(Long userId) {
        return userEditMapper.getUserEditById(userId);
    }

    public int updateUserEdit(UserEdit userEdit) {
        int result = userEditMapper.updateUserEdit(userEdit);
        System.out.println("更新用户信息 SQL 执行结果：" + result);
        return result;
    }


    public int deleteUserEdit(Long userId) {
        return userEditMapper.deleteUserEdit(userId);
    }
}
