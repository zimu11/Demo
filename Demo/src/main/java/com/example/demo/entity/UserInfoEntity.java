package com.example.demo.entity;


import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 *
 *
 * @author zimu
 * @email zimu@gmail.com
 * @date 2023-07-25 11:31:48
 */
@Data
@ApiModel("用户登录信息")
@TableName("user_info")
public class UserInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	@TableId
	private String id;
	/**
	 * 用户姓名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String password;

}
