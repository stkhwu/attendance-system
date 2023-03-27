package com.ustage.apogattendance.service;

import com.ustage.apogattendance.entity.Practice;
import com.ustage.apogattendance.model.PracticeDto;

import java.util.List;

public interface PracticeService {

    List<Practice> getAllPractice();

    Practice getPracticeById(Long id);

    void addPractice(List<PracticeDto> practiceDtos);

    void updatePracticeDetail(List<PracticeDto> practiceDtos);

    void deletePratice(List<Long> ids);
}
