package com.ustage.apogattendance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "attendance")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    Participant participant;

    @ManyToOne
    @JoinColumn(name = "practice_id")
    Practice practice;


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Attendance) {
            return
                    ((Attendance) obj).getPractice().getId().equals(this.getPractice().getId())
                    &&
                    ((Attendance) obj).getParticipant().getId().equals(this.getParticipant().getId());
        }
        return super.equals(obj);
    }
}
