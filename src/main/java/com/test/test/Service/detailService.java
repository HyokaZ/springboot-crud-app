package com.test.test.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.test.Model.detail;
import com.test.test.Repository.detailRepo;
import com.test.test.Repository.userRepo;

@RestController
public class detailService {
    
    @Autowired
    private detailRepo detailRepo ;
    @Autowired
    private userRepo userRepo ;

    @GetMapping("/get_all_detail")
    public List<detail>get_all_detail(){
        return detailRepo.findAll();
    }

    @PostMapping("/add_detail")
    public detail add_detail(@RequestBody detail data){
        detail detail_data = detailRepo.save(data);
        return detail_data;
    }

    @PutMapping("/edit_detail/{id}")
    public detail edit_detail(@RequestBody detail data, @PathVariable(value = "id") Long id){
        detail detail_data = detailRepo.save(data);
        return detail_data;
    }

    @DeleteMapping("/delete_detail/{id}")
    public Map<String, Boolean>delete_detail(@PathVariable(value = "id") Long id){
        detailRepo.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("ลบสำเร็จ", Boolean.TRUE);
        return response;
    }
    @GetMapping("/get_detail_by_user_id/{id}")
    public List get_detail_by_user_id(@PathVariable(value = "id")Long id){
        return userRepo.get_detail_by_user_id(id);
    }
}
