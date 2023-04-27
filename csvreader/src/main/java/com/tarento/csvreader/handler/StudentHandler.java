package com.tarento.csvreader.handler;

import com.opencsv.exceptions.CsvException;
import com.tarento.csvreader.dto.Student;
import com.tarento.csvreader.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;



public class StudentHandler {

    @Autowired
    private StudentService studentService;
    public List<Student> getStudent(MultipartFile file) {
        return studentService.getStudent(file);

    }
}
