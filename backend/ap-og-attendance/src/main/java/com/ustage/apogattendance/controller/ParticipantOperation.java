package com.ustage.apogattendance.controller;


import com.ustage.apogattendance.model.ParticipantDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ParticipantOperation {

    @GetMapping("/participants")
    ResponseEntity<List<ParticipantDto>> getAllParticipant();

    @PostMapping("/participants")
    ResponseEntity<Void> addParticipant(@RequestBody List<String> names);

    @DeleteMapping("/participants")
    ResponseEntity<Void> deleteAllParticipantsByIds(@RequestBody List<Long> id);

    @PutMapping("participants")
    ResponseEntity<Void> updateParticipant(@RequestBody List<ParticipantDto> participantDtos);
}
