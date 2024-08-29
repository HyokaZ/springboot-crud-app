package com.test.test.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.test.Model.employee;



public interface employeeRepo extends JpaRepository<employee , Long> {

   @Query(value = "select * from employees where id= :id", nativeQuery = true)
    List<employee> get_employee_all(Long id);

    @Query(value = 
    " select e.id, e.name , e.salary , e.job_id , j.name , e.book_id , b.name , e.pat_id , p.name,  (select count(det.id) from details det where e.id = det.user_id) as detail ,e.lov_id "+
    " from employees e "+
    " left join jobs j on e.job_id = j.id "+
    " left join books b on e.book_id = b.id"+
    " left join pats p on e.pat_id = p.id"
    ,
    nativeQuery = true)
    List get_employee_and_job();
    
    // @Query(value = " select det.id, det.name, det.user_id "+
    // " from details det "+
    // " where det.user_id = :id", nativeQuery = true)
    // List get_detail_by_user_id(Long id);

    // @Query(value = " delete from details where det.user_id = :id ", nativeQuery = true)
    // void deleteByUSerId(Long id);
}
