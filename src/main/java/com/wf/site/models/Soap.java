package com.wf.site.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("SOAPS")
public class Soap {
    @Id
    private Long id;

    private String title;

    private String description;

    private Integer price;
}
