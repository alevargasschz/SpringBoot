package com.example.demo.model;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;
    private String bio;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;


    // @ManyToOne indica que hay una relación de muchos a uno entre User y Role. 
    // Esto significa que cada usuario tiene un rol, pero un rol puede ser asignado a muchos usuarios.
    @ManyToOne

    // @JoinColumn(name = "role_id", nullable = false) especifica la columna en la tabla de usuarios que se utilizará para almacenar la clave foránea que referencia al rol. 
    // En este caso, la columna se llamará "role_id" y no permitirá valores nulos, lo que significa que cada usuario debe tener un rol asignado.
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "createdBy")
    @JsonIgnore
    private List<Game> games;

    @OneToMany(mappedBy = "userId")
    @JsonIgnore
    private List<Comment> comments;

    @OneToMany(mappedBy = "hostId")
    @JsonIgnore
    private List<Session> sessions;

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private List<Participant> participants;
}
