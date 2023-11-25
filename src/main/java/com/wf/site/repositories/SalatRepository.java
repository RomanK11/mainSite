package com.wf.site.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wf.site.models.Salat;
import com.wf.site.models.Second;

public interface SalatRepository extends CrudRepository<Salat, Long> {
    @Query("SELECT * FROM SALATS WHERE id = :id")
    Iterable<Salat> searchById(@Param("id") Long id);

    @Query("SELECT * FROM SALATS WHERE TITLE = :title")
    Iterable<Salat> searchSalats(@Param("title") String title);

}
