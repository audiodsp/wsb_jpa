package com.capgemini.wsb.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<VisitEntity, Long> {
    List<VisitEntity> findAllByPatientId(Long patientId);
    void deleteAllByPatientId(Long patientId);
}
