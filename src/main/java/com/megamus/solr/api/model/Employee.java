package com.megamus.solr.api.model;

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
public class Employee {
    @Id
    @Field
    private int idEmployee;

    @Field
    private String name;

    @Field
    private String[] address;
}
