package com.ustage.apogattendance.service.impl;

import com.ustage.apogattendance.entity.Practice;
import com.ustage.apogattendance.model.PracticeDto;
import com.ustage.apogattendance.repository.PracticeRepository;
import com.ustage.apogattendance.service.PracticeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PracticeServiceHolder implements PracticeService {

    @Autowired
    PracticeRepository practiceRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Practice> getAllPractice() {
        return practiceRepository.findAll();
    }


    @Override
    public Practice getPracticeById(Long id) {
        return practiceRepository.getReferenceById(id);
    }

    @Override
    public void addPractice(List<PracticeDto> practiceDtos) {
        List<Practice> newPractices = new ArrayList<>();
        practiceDtos.forEach(e -> {
            Practice practice = new Practice();
            practice.setDate(e.getDate());
            practice.setVenue(e.getVenue());
            practice.setStartTime(e.getStartTime());
            practice.setEndTime(e.getEndTime());
            newPractices.add(practice);
        });
        List<Practice> currentPracticeList = getAllPractice();
        newPractices.removeAll(currentPracticeList);
        practiceRepository.saveAll(newPractices);
    }

    @Override
    public void updatePracticeDetail(List<PracticeDto> practiceDtos) {
        List<Practice> practices = new ArrayList<>();
        practiceDtos.forEach(e -> {
            Practice practice = modelMapper.map(e, Practice.class);
            practices.add(practice);
        });
        practiceRepository.saveAll(practices);
    }

    @Override
    public void deletePratice(List<Long> ids) {
        practiceRepository.deleteAllById(ids);
    }
}
