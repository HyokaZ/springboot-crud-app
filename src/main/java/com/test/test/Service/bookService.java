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
import com.test.test.Repository.bookRepo;

@RestController
public class bookService {
    @Autowired
    private bookRepo bookRepo;

     @GetMapping("/get_all_book")
    public List<book>get_all_book(){
        return bookRepo.findAll();
    }

    @PostMapping("/add_book")
    public book add_book(@RequestBody book data){
        book book_data = bookRepo.save(data);
        return book_data;
    }

    @PutMapping("/edit_book/{id}")
    public book edit_book(@RequestBody book data, @PathVariable(value = "id") Long id){
        book book_data = bookRepo.save(data);
        return book_data;
    }

    @DeleteMapping("/delete_book/{id}")
    public Map<String, Boolean>delete_book(@PathVariable(value = "id") Long id){
        bookRepo.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("ลบสำเร็จ", Boolean.TRUE);
        return response;
    }

    @GetMapping("/get_book_by_id/{id}")
    public Optional<book> get_by_id(@PathVariable(value = "id") Long id){
        return bookRepo.findById(id);
    }
}
