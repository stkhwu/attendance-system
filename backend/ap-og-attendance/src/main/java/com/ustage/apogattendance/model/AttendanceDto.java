package com.ustage.apogattendance.model;

import com.ustage.apogattendance.entity.Participant;
import com.ustage.apogattendance.entity.Practice;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AttendanceDto {
    private Long id;

    private Participant participant;

    private Practice practice;

}
