package com.cyh.hibernate.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author yunhai.chen
 * @date 2018/9/16 14:49<br>
 * Description:
 **/
@Entity
@Table(name = "user_info")
@Data
@Builder
public class User {
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "CREATE_BY")
    private String createBy;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "UPDATE_BY")
    private String updateBy;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;
}
