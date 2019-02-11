package com.cyh.mybatis.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author yunhai.chen
 * @date 2018/9/16 14:49<br>
 * Description:
 **/
@Data
@Builder
public class User {
    private Integer id;

    private String name;

    private Integer age;

    private String email;

    private String address;

    private String gender;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;
}
