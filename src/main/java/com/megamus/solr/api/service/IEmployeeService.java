package com.megamus.solr.api.service;

import com.megamus.solr.api.dto.EmployeeDTO;

import java.util.Collection;
import java.util.List;

public interface IEmployeeService {
    EmployeeDTO findEmployeeByIdEmployee(Long id);
    EmployeeDTO findEmployeeByName(String name);
    EmployeeDTO update(Long id, EmployeeDTO employeeDTO);
    EmployeeDTO insert(EmployeeDTO employeeDTO);
    void delete(Long id);
    List<EmployeeDTO> findAll();
    void saveAll(Collection c);
}
