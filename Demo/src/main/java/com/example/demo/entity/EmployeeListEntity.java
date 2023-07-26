package com.example.demo.entity;


import java.io.Serializable;

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
@ApiModel("职工信息")
@TableName("employee_list")
public class EmployeeListEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 职工ID
	 */
	private String id;
	/**
	 * 职员姓名
	 */
	private String empName;
	/**
	 * 性别
	 */
	private Integer sex;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 部门名称
	 */
	private String deptName;
	/**
	 * 学历
	 */
	private String empDegreeName;

}
