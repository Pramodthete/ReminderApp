package com.spring.pojos;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "reminders")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reminder_text")
    private String reminderText;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
