package com.tarento.csvreader.controller;

import com.opencsv.exceptions.CsvException;
import com.tarento.csvreader.dto.Student;
import com.tarento.csvreader.handler.StudentHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@RestController
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired(required = false)
    private StudentHandler studentHandler;

    @PostMapping("/upload")
    public List<Student> uploadCsv(@RequestParam("file") MultipartFile file) {
        logger.info("CSV file uploaded successfully");
        return studentHandler.getStudent(file);
    }
}
