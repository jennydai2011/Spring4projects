package com.jdai.SpringAjax.api.controller;

import com.jdai.SpringAjax.api.dto.Book;
import com.jdai.SpringAjax.api.dto.ServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/home/")
public class BookController {

    List<Book> bookStore = new ArrayList<>();

    @PostMapping("addBook")
    public ResponseEntity<Object> addBook(@RequestBody Book book){
        bookStore.add(book);
        ServiceResponse response = new ServiceResponse<Book>("success", book);
        return new ResponseEntity<Object>(response, HttpStatus.OK);

    }

    @GetMapping("getAllBooks")
    public ResponseEntity<Object> getAllBooks(){
        ServiceResponse<List<Book>> response = new ServiceResponse<List<Book>>("success", bookStore);
        return new ResponseEntity<Object>(response, HttpStatus.OK);

    }
}
