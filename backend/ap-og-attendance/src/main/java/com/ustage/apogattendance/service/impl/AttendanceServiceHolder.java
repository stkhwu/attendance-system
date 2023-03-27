package com.ustage.apogattendance.service.impl;

import com.ustage.apogattendance.entity.Attendance;
import com.ustage.apogattendance.model.AttendanceDto;
import com.ustage.apogattendance.model.AttendanceInsertDto;
import com.ustage.apogattendance.model.mapper.AttendanceMapper;
import com.ustage.apogattendance.repository.AttendanceRepository;
import com.ustage.apogattendance.service.AttendanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AttendanceServiceHolder implements AttendanceService {

    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    AttendanceMapper attendanceMapper;

    private List<Attendance> retrieveAllAttendance() {
        List<Attendance> attendanceList = attendanceRepository.findAll();
        return attendanceList;
    }

    @Override
    public List<AttendanceDto> getAllAttendance() {
        List<AttendanceDto> attendanceDtos = attendanceMapper.mapEntityListToAttendanceDtoList(retrieveAllAttendance());
        return attendanceDtos;
    }

    @Override
    public void insertAttendance(List<AttendanceInsertDto> attendanceInsertDtos) {
        List<Attendance> attendanceList = attendanceMapper.mapAttendanceInsertDtoListToEntity(attendanceInsertDtos);
        List<Attendance> currentAttendanceList = retrieveAllAttendance();
        attendanceList.removeAll(currentAttendanceList);
            attendanceRepository.saveAll(attendanceList);
    }

    @Override
    public void deleteAttendance(List<Long> idList) {
        attendanceRepository.deleteAllById(idList);
    }
}
