package com.ustage.apogattendance.service.impl;

import com.ustage.apogattendance.entity.Participant;
import com.ustage.apogattendance.model.ParticipantDto;
import com.ustage.apogattendance.repository.ParticipantRepository;
import com.ustage.apogattendance.service.ParticipantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParticipantServiceHolder implements ParticipantService {

    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public Participant getParticipantById(Long id) {
        return participantRepository.getReferenceById(id);
    }

    @Override
    public List<ParticipantDto> getAllParticipant() {
        List<ParticipantDto> participantDtos = new ArrayList<>();
        participantRepository.findAll().forEach(e -> {
            participantDtos.add(modelMapper.map(e, ParticipantDto.class));
        });
        return participantDtos;
    }

    @Override
    public void addParticipant(List<String> names) {
        List<Participant> participants = new ArrayList<>();
        names.forEach(e -> {
            Participant participant = new Participant();
            participant.setName(e);
            participants.add(participant);
        });
        participants.removeAll(participantRepository.findAll());
        participantRepository.saveAll(participants);
    }

    @Override
    public void deleteAllParticipantsByIds(List<Long> ids) {
        participantRepository.deleteAllById(ids);
    }


    @Override
    public void updateParticipantDetail(List<ParticipantDto> participantDtos) {
        List<Participant> participants = new ArrayList<>();
        participantDtos.forEach(e -> {
            Participant participant = modelMapper.map(e, Participant.class);
            participants.add(participant);
        });
        participantRepository.saveAll(participants);
    }
}
