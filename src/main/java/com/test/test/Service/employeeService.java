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

import com.test.test.Model.employee;
import com.test.test.Repository.detailRepo;
import com.test.test.Repository.employeeRepo;


@RestController
public class employeeService {
    
    @Autowired
    private employeeRepo employeeRepo;

    @Autowired
    private detailRepo detailRepo;

    @GetMapping("/get_all_employee")
    public List<employee>get_all_employee(){
        return employeeRepo.findAll();
    }

    @PostMapping("/add_employee")
    public employee add_employee(@RequestBody employee data){
        employee employee_data = employeeRepo.save(data);
        return employee_data;
    }

    @PutMapping("/edit_employee/{id}")
    public employee edit_empoyee(@RequestBody employee data, @PathVariable(value = "id") Long id){
        employee employee_data = employeeRepo.save(data);
        return employee_data;
    }

    @DeleteMapping("/delete_employee/{id}")
    public Map<String, Boolean>delete_employee(@PathVariable(value = "id") Long id){
        employeeRepo.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("ลบสำเร็จ", Boolean.TRUE);
        return response;
    }

    @GetMapping("/get_employee_and_all")
    public List get_employee_and_all(){
        return employeeRepo.get_employee_and_job();
    }
    
}
