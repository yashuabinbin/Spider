package com.example.dao;


import com.example.model.Mail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

@Mapper
public interface MailMapper {

    void insert(Mail mail);

    int updateState2Useless(@Param("uid") Integer uid);

    int selectMailUserful(@Param("uid") Integer uid, @Param("code") String code, @Param(value = "time") LocalDateTime time);
}