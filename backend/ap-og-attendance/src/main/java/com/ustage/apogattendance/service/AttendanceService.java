package com.ustage.apogattendance.service;

import com.ustage.apogattendance.entity.Attendance;
import com.ustage.apogattendance.model.AttendanceDto;
import com.ustage.apogattendance.model.AttendanceInsertDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AttendanceService {

    List<AttendanceDto> getAllAttendance();

    void insertAttendance(List<AttendanceInsertDto> attendanceInsertDtos);

    void deleteAttendance(List<Long> idList);

}
