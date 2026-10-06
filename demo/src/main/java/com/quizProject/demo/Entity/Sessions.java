package com.quizProject.demo.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "sessions")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Sessions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "session_status")
    private String sessionStatus;
    @Column(name = "started_at")
    private String startedAt;
    @Column(name = "ended_at")
    private String endedAt;

}
