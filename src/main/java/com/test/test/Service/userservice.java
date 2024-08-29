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

import com.test.test.Model.user;
import com.test.test.Repository.detailRepo;
import com.test.test.Repository.userRepo;


@RestController
public class userservice {

    @Autowired
    private userRepo user;
    @Autowired
    private detailRepo detailRepo;

    @GetMapping("/get_all_users")
    public List<user>get_all_users(){
        return user.findAll();
    }

    @PostMapping("/add_user")
    public user add_User(@RequestBody user data){
        user User_data = user.save(data);
        return User_data;
    }

    @PutMapping("/edit_user/{id}")
    public user edit_User(@RequestBody user data, @PathVariable(value = "id") Long id){
        user User_data = user.save(data);
        return User_data;
    }

    @DeleteMapping("/delete_user/{id}")
    public Map<String, Boolean>delete_user(@PathVariable(value = "id") Long id){
        user.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("ลบสำเร็จ", Boolean.TRUE);
        return response;
    }

    @GetMapping("/get_by_id/{id}")
    public Optional<user> get_by_id(@PathVariable(value = "id") Long id){
        return user.findById(id);
    }

    @GetMapping("/get_user_all_by_sql/{id}")
    public List<user>get_user_all_by_sql(@PathVariable(value = "id") Long id){
        return user.get_user_all(id);
    }

    @GetMapping("/get_user_and_job")
    public List get_user_and_job(){
        return user.get_user_and_job();
    }

    @DeleteMapping("/deleteByUSerId/{id}")
    public void deleteByUSerId(@PathVariable(value = "id")Long id){
        user.deleteByUSerId(id);
        
    }

}
