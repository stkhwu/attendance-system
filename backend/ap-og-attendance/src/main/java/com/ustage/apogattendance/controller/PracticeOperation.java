package com.ustage.apogattendance.controller;

import com.ustage.apogattendance.entity.Practice;
import com.ustage.apogattendance.model.PracticeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface PracticeOperation {

    @GetMapping("/practices")
    ResponseEntity<List<Practice>> getAllPractice();

    @PostMapping("/practices")
    ResponseEntity<Void> addPractices(@RequestBody List<PracticeDto> practiceDtos);

    @PutMapping("/practices")
    ResponseEntity<Void> updatePractices(@RequestBody List<PracticeDto> practiceDtos);

    @DeleteMapping("/practices")
    ResponseEntity<Void> deletePractices(@RequestBody List<Long> ids);
}
