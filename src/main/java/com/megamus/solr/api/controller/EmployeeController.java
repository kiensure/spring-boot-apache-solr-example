package com.megamus.solr.api.controller;

import com.megamus.solr.api.dto.EmployeeDTO;
import com.megamus.solr.api.entity.EmployeeEntity;
import com.megamus.solr.api.repository.EmployeeRepository;
import com.megamus.solr.api.service.IEmployeeService;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private IEmployeeService service;

    @PostConstruct
    public void addEmployee() {
        List<EmployeeEntity> employees = new ArrayList<>();
        employees.add(new EmployeeEntity(1L, "Kiensure", new String[]{"Danang","HCM","Hanoi"}));
        employees.add(new EmployeeEntity(2L, "Megamus", new String[]{"Dongnai","Binhduong","Cantho"}));
        employees.add(new EmployeeEntity(3L, "Kiensure", new String[]{"Hagiang","Hoabinh","Laocai"}));
        service.saveAll(employees);
    }

    @GetMapping("/getEmployees")
    public Iterable<EmployeeDTO> getEmployees() {
        return service.findAll();
    }

    @GetMapping("/getEmployees/{name}")
    public EmployeeDTO getEmployeeByName(@PathVariable String name) {
        return service.findEmployeeByName(name);
    }

    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO dto) {
        return ResponseEntity.ok(service.insert(dto));
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable String id, @RequestBody EmployeeDTO dto) {
        EmployeeDTO returnDto = service.update(Long.valueOf(id), dto);

        if(returnDto != null) {
            return ResponseEntity.ok(returnDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
