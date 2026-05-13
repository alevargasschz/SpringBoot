package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// @Data funciona como un atajo para generar automáticamente los métodos getters, setters, toString, equals y hashCode en la clase Role. 
// Esto reduce la cantidad de código que necesitas escribir manualmente y hace que tu clase sea más limpia y fácil de mantener.
@Data
@NoArgsConstructor

// @Entity indica que esta clase es una entidad de JPA (Java Persistence API) y se mapeará a una tabla en la base de datos. 
// Esto permite que puedas realizar operaciones de persistencia (como guardar, actualizar, eliminar) en objetos de esta clase utilizando un repositorio de Spring Data JPA.
// Tambien se puede poner @Entity(name = "roles") para indicar el nombre de la tabla en la base de datos, si no se especifica, se usará el nombre de la clase por defecto.
@Entity(name = "roles")
public class Role {
    // @Id indica que el campo id es la clave primaria de la entidad. 
    // Esto es necesario para que JPA pueda identificar de manera única cada instancia de Role en la base de datos.
    @Id

    // @GeneratedValue(strategy = GenerationType.IDENTITY) indica que el valor del campo id se generará automáticamente por la base de datos utilizando una estrategia de identidad. 
    // Esto significa que cada vez que se inserte un nuevo registro en la tabla, la base de datos asignará automáticamente un valor único al campo id, generalmente incrementando el valor anterior en uno.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;


    // @OneToMany(mappedBy = "role") indica que hay una relación de uno a muchos entre Role y User. 
    // Esto significa que un rol puede ser asignado a muchos usuarios, pero cada usuario solo puede tener un rol. 
    // El atributo mappedBy se utiliza para indicar que la relación está mapeada por el campo "role" en la clase User, 
    // lo que significa que la tabla de usuarios tendrá una columna de clave foránea que referencia a la tabla de roles.
    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    @JsonIgnore
    @ToString.Exclude
    private List<User> users;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    @JsonIgnore
    @ToString.Exclude
    private List<RolePermission> rolePermissions;
}

// ORM (Object-Relational Mapping) es una técnica de programación que permite convertir datos entre sistemas incompatibles utilizando objetos orientados a la programación. 
// En el contexto de Java y Spring Boot, JPA (Java Persistence API) es una especificación de ORM que permite mapear objetos Java a tablas en una base de datos relacional. 
// Al usar JPA, puedes definir tus entidades (como la clase Role) y luego utilizar un repositorio de Spring Data JPA para realizar operaciones de persistencia sin tener que escribir consultas SQL manualmente.
