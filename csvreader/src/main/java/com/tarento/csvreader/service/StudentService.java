package com.tarento.csvreader.service;


import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.tarento.csvreader.dto.Student;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    public List<Student> getStudent(MultipartFile file) {
        List<Student> studentList = null;
        try {
            Reader reader = new InputStreamReader(file.getInputStream());
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            List<String[]> rows = csvReader.readAll();
            studentList = new ArrayList<>();
            for (String[] row : rows) {
                String rollNo = row[0];
                String dob = row[1];
                Student build = Student.builder().build();
                build.setDob(LocalDate.parse(dob));
                build.setRollNo(Integer.parseInt(rollNo));
                studentList.add(build);
            }
        }catch (IOException ioException){
            ioException.printStackTrace();
        } catch (CsvException csvException){
            csvException.printStackTrace();
        }
        return studentList;
    }

}
