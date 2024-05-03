package com.its.orientaTest.repository;

import com.its.orientaTest.model.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

    @Query(value = "SELECT id, tipo_test FROM test", nativeQuery = true)
    List<Object[]> findAllTestIdsAndCategories();
}