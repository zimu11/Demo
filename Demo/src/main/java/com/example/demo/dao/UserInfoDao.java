package com.example.demo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 *
 * @author zimu
 * @email zimu@gmail.com
 * @date 2023-07-25 11:31:48
 */
@Mapper
public interface UserInfoDao extends BaseMapper<UserInfoEntity> {

}
