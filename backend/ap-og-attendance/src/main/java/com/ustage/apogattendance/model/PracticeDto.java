package com.ustage.apogattendance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PracticeDto implements Serializable {
    private Long id;

    private LocalDate date;

    private String venue;

    private LocalTime startTime;

    private LocalTime endTime;
}
