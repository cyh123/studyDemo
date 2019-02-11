package com.cyh.mybatis.mapper;

import com.cyh.mybatis.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author yunhai.chen
 * @date 2018/9/16 15:03<br>
 * Description:
 **/
public interface UserMapper {
    @Select("SELECT * FROM user_info")
    @Results({@Result(property = "id", column = "ID"),
            @Result(property = "name", column = "NAME"),
            @Result(property = "age", column = "AGE"),
            @Result(property = "email", column = "EMAIL"),
            @Result(property = "address", column = "ADDRESS"),
            @Result(property = "gender", column = "GENDER"),
            @Result(property = "createBy", column = "CREATE_BY"),
            @Result(property = "createTime", column = "CREATE_TIME"),
            @Result(property = "updateBy", column = "UPDATE_BY"),
            @Result(property = "updateTime", column = "UPDATE_TIME")})
    List<User> find(Integer page, Integer size);

    @Insert("INSERT INTO user_info(NAME, AGE, EMAIL, ADDRESS, GENDER, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME) VALUES(#{name},#{age},#{email},#{address},#{gender},#{createBy},#{createTime},#{updateBy},#{updateTime})")
    void insert(User user);

    @Delete("DELETE FROM user_info WHERE NAME = #{name}")
    void deleteByName(@Param("name") String name);

    @Select("SELECT * FROM user_info WHERE name = #{name}")
    User findByName(@Param(("name")) String name);
}
