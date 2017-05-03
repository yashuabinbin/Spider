package com.example.dao;


import com.example.model.Mail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

@Mapper
public interface MailMapper {

    void insert(Mail mail);

    int updateState2Useless(@Param(value = "uid") Integer uid, @Param(value = "code") String code, @Param(value = "time") LocalDateTime time);

    int selectMailUserful(@Param(value = "uid") Integer uid, @Param(value = "code") String code, @Param(value = "time") LocalDateTime time);
}