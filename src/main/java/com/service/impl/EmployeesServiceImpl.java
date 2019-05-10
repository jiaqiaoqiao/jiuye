package com.service.impl;

import com.dao.CountriesMapper;
import com.dao.DepartmentsMapper;
import com.dao.EmployeesMapper;
import com.dao.LocationsMapper;
import com.dto.*;
import com.github.pagehelper.PageHelper;
import com.service.EmployeesService;
import com.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeesServiceImpl implements EmployeesService{
    @Autowired
    private EmployeesMapper employeesMapper;
    @Autowired
    private CountriesMapper countriesMapper;
    @Autowired
    private DepartmentsMapper departmentsMapper;
    @Autowired
    private LocationsMapper locationsMapper;

    @Override
    public List employeeList(Criteria criteria) {
      /*  PageHelper.startPage(pageIndex,pageSize);*/
        List<Employees> employeeList = employeesMapper.employeeList(criteria);
        return employeeList;
    }
    @Override
    public List countryList() {

        return countriesMapper.selectByExample(null);
    }

    @Override
    public List locaList(String coutryId) {
        LocationsExample example = new LocationsExample();
        LocationsExample.Criteria criteria = example.createCriteria();
        criteria.andCountryIdEqualTo(coutryId);
        return locationsMapper.selectByExample(example);
    }

    @Override
    public List departmentList(String locaId) {
        DepartmentsExample example = new DepartmentsExample();
        DepartmentsExample.Criteria criteria = example.createCriteria();
        criteria.andLocationIdEqualTo(Short.valueOf(locaId));
        return departmentsMapper.selectByExample(example);
    }

    @Override
    public void del(Integer employeeId) {
        employeesMapper.deleteByPrimaryKey(employeeId);
    }

    @Override
    public List<Map> getde() {
        return employeesMapper.getde();
    }

    @Override
    public Map zui() {
        List<Map> err=departmentsMapper.zui();

        String[] a=new String[err.size()];
        int[] a1=new int[err.size()];
        int[] a2=new int[err.size()];
        int[] a3=new int[err.size()];

        Map<String,Object> hashmap=new HashMap<>();

        for (int i = 0; i <err.size() ; i++) {
            a[i]=err.get(i).get("name")+"";
            a1[i]=err.get(i).get("x")==null?0:Integer.valueOf(err.get(i).get("x")+"");
            a2[i]=err.get(i).get("y")==null?0:Integer.valueOf(err.get(i).get("y")+"");
            a3[i]=err.get(i).get("z")==null?0:Integer.valueOf(err.get(i).get("z")+"");
        }
        hashmap.put("name",a);
        hashmap.put("x",a1);
        hashmap.put("y",a2);
        hashmap.put("z",a3);

        return hashmap;
    }


}
