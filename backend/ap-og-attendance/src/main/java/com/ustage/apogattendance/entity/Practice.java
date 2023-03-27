package com.ustage.apogattendance.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "practice")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Practice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private String venue;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Practice) {
            return ((Practice) obj).date.equals(this.getDate())
                    &&
                    ((Practice) obj).getStartTime().equals(this.getStartTime());
        }
        return super.equals(obj);
    }
}
