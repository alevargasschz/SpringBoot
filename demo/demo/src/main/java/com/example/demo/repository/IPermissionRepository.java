package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Permission;

@Repository
public interface IPermissionRepository extends JpaRepository<Permission, Integer> {
    // Ya esta el CRUD básico con JpaRepository, pero se pueden agregar consultas personalizadas si es necesario

    // Consulta personalizada para obtener los permisos de un usuario específico
    List<Permission> findByRolePermissions_Role_Users_Id (Integer userId);
}
