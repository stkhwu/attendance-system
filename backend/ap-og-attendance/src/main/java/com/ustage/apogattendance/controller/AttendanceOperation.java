package com.ustage.apogattendance.controller;

import com.ustage.apogattendance.model.AttendanceDto;
import com.ustage.apogattendance.model.AttendanceInsertDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AttendanceOperation {

    @GetMapping("/attendances")
    ResponseEntity<List<AttendanceDto>> getAllAttendance();

    @PostMapping("/attendances")
    ResponseEntity<Void> insertAttendance(@RequestBody List<AttendanceInsertDto> attendanceInsertDtos);

    @DeleteMapping("/attendances")
    ResponseEntity<Void> deleteAttendance(@RequestBody List<Long> ids);

}
