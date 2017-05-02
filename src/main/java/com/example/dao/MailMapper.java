package com.example.dao;


import com.example.model.Mail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MailMapper {

    void insert(Mail mail);

}