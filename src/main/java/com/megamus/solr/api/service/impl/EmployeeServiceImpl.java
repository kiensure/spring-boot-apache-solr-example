package com.megamus.solr.api.service.impl;

import com.megamus.solr.api.converter.EmployeeConverter;
import com.megamus.solr.api.dto.EmployeeDTO;
import com.megamus.solr.api.entity.EmployeeEntity;
import com.megamus.solr.api.repository.EmployeeRepository;
import com.megamus.solr.api.service.IEmployeeService;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeConverter converter;

    @Override
    public EmployeeDTO findEmployeeByIdEmployee(Long id) {
        Optional<EmployeeEntity> employeeEntity = Optional.ofNullable(repository.findByIdEmployee(id));
        EmployeeDTO employeeDTO = null;
        if (employeeEntity.isPresent()) {
            employeeDTO = converter.convertToDto(employeeEntity.get());
        }
        return employeeDTO;
    }

    @Override
    public EmployeeDTO findEmployeeByName(String name) {
        EmployeeEntity entity = repository.findByName(name);

        return converter.convertToDto(entity);
    }

    @Transactional
    @Override
    public EmployeeDTO update(Long id, EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = repository.findByIdEmployee(id);
        employeeEntity.setName(employeeDTO.getName());
        employeeEntity.setAddress(employeeDTO.getAddress());
        employeeEntity = repository.save(employeeEntity);
        return converter.convertToDto(employeeEntity);
    }

    @Override
    public EmployeeDTO insert(EmployeeDTO employeeDTO) {
        EmployeeEntity entity = converter.convertToEntity(employeeDTO);
        entity = repository.save(entity);
        return converter.convertToDto(entity);
    }

    @Override
    public void delete(Long id) {
        EmployeeEntity entity = repository.findByIdEmployee(id);
        repository.delete(entity);
    }

    @Override
    public List<EmployeeDTO> findAll() {
        List<EmployeeEntity> listEntity = new ArrayList<>();
        repository.findAll().forEach(item -> listEntity.add(item));
        return listEntity.stream().map(item -> converter.convertToDto(item)).collect(Collectors.toList());
    }

    @Override
    public void saveAll(Collection c) {
        repository.saveAll(c);
    }
}
