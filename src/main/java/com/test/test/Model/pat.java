package com.test.test.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "pats")
public class pat {
    
    private Long id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
