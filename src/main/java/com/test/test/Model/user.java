package com.test.test.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")

public class user {
    private Long id;
    private String name;
    private Float salary;
    private Long job_id;
    private Long book_id;
    private Long pat_id;
    private Long detail_id;
    private Long lov_id;

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
    public Float getSalary() {
        return salary;
    }
    public void setSalary(Float salary) {
        this.salary = salary;
    }
    public Long getJob_id() {
        return job_id;
    }
    public void setJob_id(Long job_id) {
        this.job_id = job_id;
    }
    public Long getBook_id() {
        return book_id;
    }
    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }
    public Long getPat_id() {
        return pat_id;
    }
    public void setPat_id(Long pat_id) {
        this.pat_id = pat_id;
    }
    public Long getDetail_id() {
        return detail_id;
    }
    public void setDetail_id(Long detail_id) {
        this.detail_id = detail_id;
    }
    public Long getLov_id() {
        return lov_id;
    }
    public void setLov_id(Long lov_id) {
        this.lov_id = lov_id;
    }
    
}
