package com.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.pojos.Appointment;

@Repository
public interface AppointmentDao extends JpaRepository<Appointment, Long>{

}
