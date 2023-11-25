package com.wf.site.repositories;

import org.apache.tomcat.jni.Library;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wf.site.models.Salat;
import com.wf.site.models.Soap;

public interface SoapRepository extends CrudRepository<Soap, Long> {
    @Query("SELECT * FROM SOAPS WHERE id = :id")
    Iterable<Soap> searchById(@Param("id") Long id);

    @Query("SELECT * FROM SOAPS WHERE TITLE = :title")
    Iterable<Soap> searchSoaps(@Param("title") String title);
}
