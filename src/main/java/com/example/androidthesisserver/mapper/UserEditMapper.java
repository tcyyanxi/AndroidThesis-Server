package com.example.androidthesisserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.androidthesisserver.entity.UserEdit;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserEditMapper {

    @Select("SELECT * FROM user_edit WHERE id = #{id}")
    UserEdit getUserEditById(@Param("id") Long id);

    @Insert("INSERT INTO user_edit (id, avatar, username, gender, birthday) " +
            "VALUES (#{id}, #{avatar}, #{username}, #{gender}, #{birthday})")
    int insertUserEdit(UserEdit userEdit);


    @Update("UPDATE user_edit SET avatar = #{avatar}, username = #{username}, gender = #{gender}, " +
            "birthday = #{birthday} WHERE id = #{id}")
    int updateUserEdit(UserEdit userEdit);

    @Delete("DELETE FROM user_edit WHERE id = #{id}")
    int deleteUserEdit(@Param("id") Long userId);
}
