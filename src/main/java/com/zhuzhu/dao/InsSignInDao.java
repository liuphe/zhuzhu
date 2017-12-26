package com.zhuzhu.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.zhuzhu.entry.InsSignIn;

@Mapper
public interface InsSignInDao{
    
    @Insert("insert into tbl_login(name,password) "+
            "values(#{name},#{password})")
    int save(InsSignIn  insSingIn);
}