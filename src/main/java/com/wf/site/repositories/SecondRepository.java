package com.wf.site.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wf.site.models.Second;

public interface SecondRepository extends CrudRepository<Second, Long> {
    @Query("SELECT * FROM SECONDS WHERE id = :id")
    Iterable<Second> searchById(@Param("id") Long id);
    
}
