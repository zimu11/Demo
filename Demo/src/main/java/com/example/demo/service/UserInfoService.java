package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.UserInfoEntity;
import com.example.demo.untils.Result;


import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author zimu
 * @email zimu@gmail.com
 * @date 2023-07-25 11:31:48
 */
public interface UserInfoService extends IService<UserInfoEntity> {

    List queryPage(Map<String, Object> params);

    Result login(Map<String, String> params);
}

