package com.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.pojos.Reminder;

@Repository
public interface ReminderDao extends JpaRepository<Reminder, Long>{

}
