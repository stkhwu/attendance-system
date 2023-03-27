package com.ustage.apogattendance.model.mapper;

import com.ustage.apogattendance.entity.Participant;
import com.ustage.apogattendance.entity.Practice;
import com.ustage.apogattendance.entity.Attendance;
import com.ustage.apogattendance.model.AttendanceDto;

import com.ustage.apogattendance.model.AttendanceInsertDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceMapper {
    @Autowired
    ModelMapper modelMapper;

    public Attendance mapAttendanceDtoToEntity (AttendanceDto attendanceDto) {
        return modelMapper.map(attendanceDto, Attendance.class);
    }

    public List<Attendance> mapAttendanceInsertDtoListToEntity (List<AttendanceInsertDto> attendanceInsertDtos) {
        List<Attendance> attendanceList = new ArrayList<>();
        attendanceInsertDtos.forEach(e -> {
                    Participant participant = new Participant();
                    participant.setId(e.getParticipantId());
                    Practice practice = new Practice();
                    practice.setId(e.getPracticeId());
                    Attendance attendance = new Attendance();
                    attendance.setParticipant(participant);
                    attendance.setPractice(practice);
                    attendanceList.add(attendance);
                });



        return attendanceList;
    }

    public AttendanceDto mapEntitytoAttendanceDto  (Attendance attendance) {
        return modelMapper.map(attendance, AttendanceDto.class);
    }

    public List<AttendanceDto> mapEntityListToAttendanceDtoList (List<Attendance> attendanceList ) {
        return attendanceList.stream().map(e -> mapEntitytoAttendanceDto(e)).collect(Collectors.toList());
    }

    public List<Attendance> mapDtoListToEntityList (List<AttendanceDto> dtoList) {
        return dtoList.stream().map(e -> mapAttendanceDtoToEntity(e)).collect(Collectors.toList());
    }

}
