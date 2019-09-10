package com.megamus.solr.api.converter;

import com.megamus.solr.api.dto.EmployeeDTO;
import com.megamus.solr.api.entity.EmployeeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {
    @Autowired
    private ModelMapper modelMapper;

    public EmployeeDTO convertToDto(EmployeeEntity entity) {
        return modelMapper.map(entity, EmployeeDTO.class);
    }

    public EmployeeEntity convertToEntity(EmployeeDTO dto) {
        return modelMapper.map(dto, EmployeeEntity.class);
    }
}
