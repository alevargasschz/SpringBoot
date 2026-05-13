package com.example.demo.dto;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionResponse {
    private Integer id;
    private Timestamp date_time;
    private String location;
    private String status;
    private String notes;
    private String gamaName;
    private String hostName;
}
