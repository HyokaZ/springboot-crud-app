package com.test.test.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.test.Model.job;


public interface jobRepo extends JpaRepository<job , Long>{
    
    @Query(value = " select j.id, j.id, j.name from jobs j ", nativeQuery = true)
    List get_jobs();
}
