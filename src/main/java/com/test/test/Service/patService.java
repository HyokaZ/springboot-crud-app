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

import com.test.test.Model.book;
import com.test.test.Model.pat;
import com.test.test.Repository.patRepo;

@RestController
public class patService {
    @Autowired
    private patRepo patRepo;

    @GetMapping("/get_all_pat")
    public List<pat>get_all_pat(){
        return patRepo.findAll();
    }

    @PostMapping("/add_pat")
    public pat add_pat(@RequestBody pat data){
        pat pat_data = patRepo.save(data);
        return pat_data;
    }

    @PutMapping("/edit_pat/{id}")
    public pat edit_pat(@RequestBody pat data, @PathVariable(value = "id") Long id){
        pat pat_data = patRepo.save(data);
        return pat_data;
    }

    @DeleteMapping("/delete_pat/{id}")
    public Map<String, Boolean>delete_pat(@PathVariable(value = "id") Long id){
        patRepo.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("ลบสำเร็จ", Boolean.TRUE);
        return response;
    }

    @GetMapping("/get_pat_by_id/{id}")
    public Optional<pat> get_by_id(@PathVariable(value = "id") Long id){
        return patRepo.findById(id);
    }
}
