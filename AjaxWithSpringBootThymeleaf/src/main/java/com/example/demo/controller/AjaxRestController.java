package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@RestController
@RequestMapping("api/ajaxrest")
public class AjaxRestController {
	
	@RequestMapping(value="demo1",method=RequestMethod.GET,
			produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> demo1(){
		try {
			ResponseEntity<String> responseEntity =
					new ResponseEntity<String>("Demo1 response", HttpStatus.OK);
			return responseEntity;
		}catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="demo2/{fullname}",method=RequestMethod.GET,
			produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> demo2(@PathVariable("fullname") String fullname){
		try {
			ResponseEntity<String> responseEntity =
					new ResponseEntity<String>("Hi "+fullname, HttpStatus.OK);
			return responseEntity;
		}catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="demo3",method=RequestMethod.GET,
			produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<Product> demo3(){
		try {
			ProductRepository repo = new ProductRepository();
			ResponseEntity<Product> responseEntity =
					new ResponseEntity<Product>(repo.find(), HttpStatus.OK);
			return responseEntity;
		}catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="demo4",method=RequestMethod.GET,
			produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Product>> demo4(){
		try {
			ProductRepository repo = new ProductRepository();
			ResponseEntity<List<Product>> responseEntity =
					new ResponseEntity<List<Product>>(repo.findAll(), HttpStatus.OK);
			return responseEntity;
		}catch (Exception e) {
			return new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST);
		}
	}
}
