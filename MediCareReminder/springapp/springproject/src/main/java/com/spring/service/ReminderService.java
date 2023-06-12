package com.spring.service;

import org.springframework.stereotype.Service;

@Service
public class ReminderService {

    public void sendReminder(String remind) {
    	
        // Send reminders logic...
    	System.out.println("its time for "+remind);
    }

}
