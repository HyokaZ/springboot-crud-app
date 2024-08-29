package com.test.test.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.test.Model.job;

import com.test.test.Repository.jobRepo;

@RestController
public class jobService {
    
    @Autowired
    private jobRepo jobRepo;

     @GetMapping("/get_all_job")
    public List<job>get_all_Jobs(){
        return jobRepo.findAll();
    }

    @PostMapping("/add_job")
    public job add_job(@RequestBody job data){
        job job_data = jobRepo.save(data);
        return job_data;
    }

    @PutMapping("/edit_job/{id}")
    public job edit_job(@RequestBody job data, @PathVariable(value = "id") Long id){
        job job_data = jobRepo.save(data);
        return job_data;
    }

    @DeleteMapping("/delete_job/{id}")
    public Map<String, Boolean>delete_job(@PathVariable(value = "id") Long id){
        jobRepo.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("ลบสำเร็จ", Boolean.TRUE);
        return response;
    }

    @GetMapping("/get_job_by_id/{id}")
    public Optional<job> get_by_id(@PathVariable(value = "id") Long id){
        return jobRepo.findById(id);
    }

    @GetMapping("/get_jobs")
    public List get_jobs(){
        return jobRepo.get_jobs();
    }
}
