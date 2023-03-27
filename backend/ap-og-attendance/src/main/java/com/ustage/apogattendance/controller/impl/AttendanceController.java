package com.ustage.apogattendance.controller.impl;

import com.ustage.apogattendance.controller.AttendanceOperation;
import com.ustage.apogattendance.entity.Attendance;
import com.ustage.apogattendance.model.AttendanceDto;
import com.ustage.apogattendance.model.AttendanceInsertDto;
import com.ustage.apogattendance.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AttendanceController implements AttendanceOperation {

    @Autowired
    AttendanceService attendanceService;


    @Override
    public ResponseEntity<List<AttendanceDto>> getAllAttendance() {
        return ResponseEntity.ok(attendanceService.getAllAttendance());
    }

    @Override
    public ResponseEntity<Void> insertAttendance(List<AttendanceInsertDto> attendanceInsertDtos) {
        attendanceService.insertAttendance(attendanceInsertDtos);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteAttendance(List<Long> ids) {
        attendanceService.deleteAttendance(ids);
        return ResponseEntity.ok().build();
    }
}
