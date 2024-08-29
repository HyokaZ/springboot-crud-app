package com.test.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.test.Model.book;


public interface bookRepo extends JpaRepository<book , Long>{
    
}
