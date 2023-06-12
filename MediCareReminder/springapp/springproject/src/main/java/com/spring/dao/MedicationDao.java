package com.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.pojos.Medication;

@Repository
public interface MedicationDao extends JpaRepository<Medication, Long>{

}
