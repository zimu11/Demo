package com.example.demo.controller;

import java.util.Map;
import com.example.demo.service.UserInfoService;
import com.example.demo.untils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;





/**
 *
 *
 * @author zimu
 * @email zimu@gmail.com
 * @date 2023-07-25 11:31:48
 */
@RestController
@CrossOrigin
@Api(value = "用户登录接口", tags = "用户登录退出相关的接口")
@RequestMapping("userinfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 登录
     */
    @ApiOperation("登录接口")
    @ApiImplicitParam(value = "params",dataType = "Map<String, String>",paramType = "登录")
    @RequestMapping("/login")
    public Result list(@RequestParam Map<String, String> params){
        Result result=userInfoService.login(params);
        return result;
    }
    /**
     * token
     */
    @ApiOperation("获取token")
    @ApiImplicitParam(value = "params",dataType = "Map<String, String>")
    @RequestMapping("/info")
    public Result info(@RequestParam Map<String, Object> params){
        return Result.ok();
    }
    /**
     * token
     */
    @ApiOperation("退出登录")
    @RequestMapping("/logout")
    public Result logout(){
        return Result.ok();
    }



}
