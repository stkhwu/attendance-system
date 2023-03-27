package com.ustage.apogattendance.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceInsertDto implements Serializable {

//    @JsonProperty(value = "participant_id")
    private Long participantId;

//    @JsonProperty(value = "practice_id")
    private Long practiceId;

}
