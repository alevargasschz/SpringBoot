/*
package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

// @Embeddable indica que esta clase es una clave primaria compuesta que se puede incrustar en otra entidad. 
// Esto es útil para representar relaciones de muchos a muchos, como la relación entre roles y permisos en este caso. 
// Al usar @Embeddable, puedes definir una clase que contenga los campos que forman la clave primaria compuesta y luego usar esta clase como parte de la entidad que representa la relación entre roles y permisos.
@Embeddable
public class RolePermissionPK {
    
    @Column(name = "role_id", insertable = false, updatable = false)
    private Integer roleId;

    @Column(name = "permission_id", insertable = false, updatable = false)
    private Integer permissionId;
}

*/
