package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.demo.entity.EmployeeListEntity;
import com.example.demo.service.EmployeeListService;
import com.example.demo.untils.PageUtils;
import com.example.demo.untils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import javafx.scene.control.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


/**
 * @author zimu
 * @email zimu@gmail.com
 * @date 2023-07-25 11:31:48
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("employeelist")
@Api(value = "职工列表接口", tags = "职工管理相关的接口")
public class EmployeeListController {
    @Autowired
    private EmployeeListService employeeListService;

    /**
     * 列表
     */
    @ApiOperation("查询全部职工信息")
    @ApiImplicitParam(value = "params",dataType = "Map<String, Object> params",paramType = "查询")
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params) throws Throwable {
        PageUtils page = employeeListService.queryPage(params);

        return Result.ok().put("data", page);
    }


    /**
     * 信息
     */
    @ApiOperation("根据查询一条职工信息")
    @ApiImplicitParam(value = "id",dataType = "String")
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") String id) {
        EmployeeListEntity employeeList = employeeListService.getById(id);

        return Result.ok().put("employeeList", employeeList);
    }

    /**
     * 保存
     */
    @ApiOperation("保存职工数据")
    @ApiImplicitParam(value = "employeeList",dataType = "EmployeeListEntity")
    @RequestMapping("/save")
    public Result save(@RequestBody EmployeeListEntity employeeList) {
        employeeListService.save(employeeList);

        return Result.ok();
    }

    /**
     * 修改
     */
    @ApiOperation("修改职工信息")
    @ApiImplicitParam(value = "employeeList",dataType = "EmployeeListEntity")
    @RequestMapping("/update")
    public Result update(@RequestBody EmployeeListEntity employeeList) {
        employeeListService.updateById(employeeList);

        return Result.ok();
    }

    /**
     * 删除
     */
    @ApiOperation("删除职工信息")
    @ApiImplicitParam(value = "ids",dataType = "String[]")
    @RequestMapping("/delete")
    public Result delete(@RequestBody String[] ids) {
        employeeListService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

    /**
     * 导出
     */
    @ApiOperation("导出excel")
    @ApiImplicitParam(value = "listEntityList1",dataType = "Map<String, String>")
    @RequestMapping("/printExcel")
    public Result printExcel(@RequestParam Map<String, String> listEntityList1) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data");
        String employeeListString = listEntityList1.get("0");
        List<EmployeeListEntity> listEntityList = JSONArray.parseArray(employeeListString, EmployeeListEntity.class);
        int rowIndex = 0;
        Row headerRow = sheet.createRow(rowIndex++);
        headerRow.createCell(0).setCellValue("序号");
        headerRow.createCell(1).setCellValue("姓名");
        headerRow.createCell(2).setCellValue("性别");
        headerRow.createCell(3).setCellValue("年龄");
        headerRow.createCell(4).setCellValue("部门");
        headerRow.createCell(5).setCellValue("学历");
        for (EmployeeListEntity data : listEntityList) {
            Row row = sheet.createRow(rowIndex++);
            Cell cell = (Cell) row.getCell(1);
            row.createCell(0).setCellValue(data.getId());
            row.createCell(1).setCellValue(data.getEmpName());
            row.createCell(2).setCellValue(data.getSex()==1?"男":"女");
            row.createCell(3).setCellValue(data.getAge());
            row.createCell(4).setCellValue(data.getDeptName());
            row.createCell(5).setCellValue(data.getEmpDegreeName());
        }
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\马法腾\\Downloads\\信息.xlsx");
        workbook.write(outputStream);

        return Result.ok();
    }

}
