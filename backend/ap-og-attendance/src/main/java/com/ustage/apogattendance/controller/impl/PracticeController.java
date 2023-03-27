package com.ustage.apogattendance.controller.impl;

import com.ustage.apogattendance.controller.PracticeOperation;
import com.ustage.apogattendance.entity.Practice;
import com.ustage.apogattendance.model.PracticeDto;
import com.ustage.apogattendance.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PracticeController implements PracticeOperation {

    @Autowired
    PracticeService practiceService;

    @Override
    public ResponseEntity<List<Practice>> getAllPractice() {
        return ResponseEntity.ok().body(practiceService.getAllPractice());
    }

    @Override
    public ResponseEntity<Void> addPractices(List<PracticeDto> practiceDtos) {
        practiceService.addPractice(practiceDtos);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updatePractices(List<PracticeDto> practiceDtos) {
        practiceService.updatePracticeDetail(practiceDtos);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deletePractices(List<Long> ids) {
        practiceService.deletePratice(ids);
        return ResponseEntity.ok().build();
    }
}
