package com.upcloud.mapper;


import com.upcloud.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {

    @Insert("insert into user(username,password) values(#{username},#{password})")
    void save(User user);

    @Select("select * from user where id=#{id}")
    User select(@Param("id") String id);

}
