package com.ustage.apogattendance.service;

import com.ustage.apogattendance.entity.Participant;
import com.ustage.apogattendance.model.ParticipantDto;

import java.util.List;

public interface ParticipantService {

    List<ParticipantDto> getAllParticipant();

    Participant getParticipantById(Long id);

    void addParticipant(List<String> names);

    void deleteAllParticipantsByIds(List<Long> ids);

    void updateParticipantDetail(List<ParticipantDto> participantDtos);
}
