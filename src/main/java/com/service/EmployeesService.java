package com.service;

import com.dto.Criteria;

import java.util.List;
import java.util.Map;

public interface EmployeesService {
  

    List countryList();

    List employeeList(Criteria criteria);

    List locaList(String coutryId);

    List departmentList(String locaId);


    void del(Integer employeeId);

    List<Map> getde();

    Map zui();
}
