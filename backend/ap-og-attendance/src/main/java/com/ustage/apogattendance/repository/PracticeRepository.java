package com.ustage.apogattendance.repository;

import com.ustage.apogattendance.entity.Participant;
import com.ustage.apogattendance.entity.Practice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticeRepository extends JpaRepository<Practice, Long> {
}
