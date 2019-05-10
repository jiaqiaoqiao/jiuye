package com.controller;

import com.dto.*;
import com.service.EmployeesService;
import com.utils.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;

    /**
     * 列表
     * @param employeeName
     * @param model
     * @param criteria
     * @return
     * @throws Exception
     */
    @RequestMapping("list")
    public String list(@RequestParam(defaultValue = "")String employeeName, Model model, Criteria criteria){
        List<Employees> employeeList = employeesService.employeeList(criteria);
       /* BaseModel page = new BaseModel();*/
       /* page.calculatePage(employeeList,pageIndex,pageSize);*/
        model.addAttribute("employeeList",employeeList);
       /* model.addAttribute("page",page);*/
        return "employeeList";
    }

    /**
     * 查询城市表
     * @return
     */
    @RequestMapping("countryList")
    @ResponseBody
    public List<Countries> countryList(){
        return employeesService.countryList();
    }

    /**
     * 地址
     * @param coutryId
     * @return
     */
    @RequestMapping("locaList")
    @ResponseBody
    public List<Locations> locaList(String coutryId){
        return  employeesService.locaList(coutryId);
    }

    /**
     * 部门
     * @param locaId
     * @return
     */
    @RequestMapping("departmentList")
    @ResponseBody
    public List<Departments> departmentList(String locaId){
        return  employeesService.departmentList(locaId);
    }

    /**
     * 删除
     * @param employeeId
     * @return
     */
    @RequestMapping("del")
    public String del(Integer employeeId){
        employeesService.del(employeeId);
        return "redirect:list";
    }

    /**
     * 部门和人数图
     * @return
     */
    @RequestMapping("tubiao")
    @ResponseBody
    public  List<Map> getde(){
        List<Map> list=employeesService.getde();
        return list;
    }

    /**
     * 最高 最低 平均工资
     * @return
     */
    @RequestMapping("zui")
    @ResponseBody
    public  Map zui(){
        Map list=employeesService.zui();
        return  list;
    }
}
