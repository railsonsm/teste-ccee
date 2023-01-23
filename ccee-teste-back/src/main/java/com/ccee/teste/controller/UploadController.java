package com.ccee.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ccee.teste.service.UploadService;

@RequestMapping("/files")
@RestController
public class UploadController {

   @Autowired
   private UploadService uploadService;

   @PostMapping("/upload")
   public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {
      uploadService.uploadFile(file);
 
      return ResponseEntity.status(HttpStatus.CREATED).build();
     
   }
}
