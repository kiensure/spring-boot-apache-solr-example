package com.megamus.solr.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SolrDocument(collection = "employee")
public class EmployeeEntity {
    @Id
    @Field
    private Long idEmployee;

    @Field
    private String name;

    @Field
    private String[] address;
}
