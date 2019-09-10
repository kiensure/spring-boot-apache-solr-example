package com.megamus.solr.api.repository;

import com.megamus.solr.api.entity.EmployeeEntity;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface EmployeeRepository extends SolrCrudRepository<EmployeeEntity, Long> {
    EmployeeEntity findByName(String name);
    EmployeeEntity findByIdEmployee(Long id);
}
