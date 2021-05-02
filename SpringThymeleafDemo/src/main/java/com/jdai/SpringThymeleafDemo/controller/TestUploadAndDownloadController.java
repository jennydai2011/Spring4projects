package com.jdai.SpringThymeleafDemo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.*;

@RestController
public class TestUploadAndDownloadController {

    @RequestMapping("down")
    public ResponseEntity<byte[]> download(HttpSession session) throws IOException {
        //find file path
        String realPath = session.getServletContext().getRealPath("static");
        System.out.println(" realpath is :" + realPath);

        String finalPath = realPath + File.separator + "iamges.jpeg";
        System.out.println(" final path is:" + finalPath);

        InputStream is = new FileInputStream(finalPath);

        byte[] b = new byte[is.available()]; //maximum

        HttpHeaders headers = new HttpHeaders();
        headers.add("Contet-Disposition", "attachment; filename=image.jpeg");
        HttpStatus statuscode = HttpStatus.OK;

        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(b, headers, statuscode);
        return entity;
    }

//    public FileSystemResource downloadFile(@Param(value="id") Long id) {
//        Product product = productRepo.findOne(id);
//        return new FileSystemResource(new File(product.getFileUrl()));
//    }
}
