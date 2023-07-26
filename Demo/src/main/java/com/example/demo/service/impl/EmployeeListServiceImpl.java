package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.EmployeeListDao;
import com.example.demo.entity.EmployeeListEntity;
import com.example.demo.service.EmployeeListService;
import com.example.demo.untils.PageUtils;
import com.example.demo.untils.Query;
import org.springframework.stereotype.Service;

import java.util.*;



@Service("employeeListService")
public class EmployeeListServiceImpl extends ServiceImpl<EmployeeListDao, EmployeeListEntity> implements EmployeeListService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) throws Throwable {
        QueryWrapper<EmployeeListEntity> wrapper = new QueryWrapper<>();
        if(!StringUtils.isBlank((CharSequence) params.get("key"))){
            wrapper.like("emp_name",params.get("key"));
        }  if(!StringUtils.isBlank((CharSequence) params.get("department"))){
            wrapper.eq("dept_name",params.get("department"));
        }  if(!StringUtils.isBlank((CharSequence) params.get("degree"))){
            wrapper.eq("emp_degree_name",params.get("degree"));
        }
//        List<EmployeeListEntity> entityList = this.baseMapper.selectList(wrapper);
        IPage<EmployeeListEntity> page = this.page(
                new Query<EmployeeListEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

}
