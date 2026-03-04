package com.example.demo.model;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private Timestamp date_time;
    private String location;
    private String status;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game gameId;

    @ManyToOne
    @JoinColumn(name = "host_id", nullable = false)
    private User hostId;

    @OneToMany(mappedBy = "sessionId")
    @JsonIgnore
    private List<Participant> participants;
}
