package com.example.demo.service.impl;

import com.example.demo.dao.UserInfoDao;
import com.example.demo.entity.UserInfoEntity;
import com.example.demo.service.UserInfoService;
import com.example.demo.untils.Result;
import org.springframework.stereotype.Service;

import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("userInfoService")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoEntity> implements UserInfoService {

    @Override
    public List<Object> queryPage(Map<String, Object> params) {

        return new ArrayList<>() ;
    }

    @Override
    public Result login(Map<String, String> params) {
        String username = params.get("username");
        String password = params.get("password");
        UserInfoEntity infoEntity = this.baseMapper.selectOne(new QueryWrapper<UserInfoEntity>().eq("user_name",username));
        if(infoEntity!=null){
            if (infoEntity.getPassword().equals(password)) {
                return Result.ok();
            }
        }
        return Result.loginError();
    }

}
