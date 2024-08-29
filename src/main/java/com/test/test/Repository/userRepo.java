package com.test.test.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.test.Model.user;

public interface userRepo extends JpaRepository<user , Long>{
    
    @Query(value = "select * from users where id= :id", nativeQuery = true)
    List<user> get_user_all(Long id);

    @Query(value = 
    " select u.id, u.name , u.salary , u.job_id , j.name , u.book_id , b.name , u.pat_id , p.name, (select count(det.id) from details det where u.id = det.user_id) as detail , u.lov_id"+
    " from users u "+
    " left join jobs j on u.job_id = j.id "+
    " left join books b on u.book_id = b.id"+
    " left join pats p on u.pat_id = p.id"
    ,
    nativeQuery = true)
    List get_user_and_job();

    @Query(value = " select det.id, det.name, det.user_id "+
    " from details det "+
    " where det.user_id = :id", nativeQuery = true)
    List get_detail_by_user_id(Long id);

    @Query(value = " delete from details where det.user_id = :id ", nativeQuery = true)
    void deleteByUSerId(Long id);
}
