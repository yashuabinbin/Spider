package com.example.dao;

import com.example.model.Seed;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SeedMapper {

    void insert(Seed seed);

}