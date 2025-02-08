package com.example.androidthesisserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.androidthesisserver.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据邮箱查找用户
     * @param email 用户邮箱
     * @return 用户对象
     */
    @Select("SELECT * FROM users WHERE email = #{email}")
    User findByEmail(String email);

    /**
     * 插入新用户
     * @param user 用户对象
     */
    @Insert("INSERT INTO users(email, is_first_login) VALUES(#{email}, #{isFirstLogin})")
    void insertUser(User user);

    /**
     * 更新用户登录状态
     * @param email 用户邮箱
     */
    @Update("UPDATE users SET is_first_login = false WHERE email = #{email}")
    void updateLoginStatus(String email);
}