package com.ustage.apogattendance.controller.impl;

import com.ustage.apogattendance.controller.ParticipantOperation;
import com.ustage.apogattendance.entity.Participant;
import com.ustage.apogattendance.model.ParticipantDto;
import com.ustage.apogattendance.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ParticipantController implements ParticipantOperation {

    @Autowired
    ParticipantService participantService;

    @Override
    public ResponseEntity<List<ParticipantDto>> getAllParticipant() {
        return ResponseEntity.ok().body(participantService.getAllParticipant());
    }

    @Override
    public ResponseEntity<Void> addParticipant(List<String> names) {
        participantService.addParticipant(names);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<Void> deleteAllParticipantsByIds(List<Long> ids) {
        participantService.deleteAllParticipantsByIds(ids);
        return ResponseEntity.accepted().build();
    }

    @Override
    public ResponseEntity<Void> updateParticipant(List<ParticipantDto> participantDtos) {
        participantService.updateParticipantDetail(participantDtos);
        return ResponseEntity.accepted().build();
    }
}
