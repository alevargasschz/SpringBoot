package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Permission;
import com.example.demo.model.Role;
import com.example.demo.model.RolePermission;
import com.example.demo.repository.IPermissionRepository;
import com.example.demo.repository.IRolePermissionRepository;
import com.example.demo.repository.IRoleRepository;
import com.example.demo.service.IRolePermissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RolePermissionService implements IRolePermissionService {
    private final IRolePermissionRepository rolePermissionRepository;
    private final IRoleRepository roleRepository;
    private final IPermissionRepository permissionRepository;

    @Transactional
    @Override
    public List<RolePermission> addPermissionsToRole(Integer roleId, List<Integer> permissionIds) {
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new IllegalArgumentException("Role not found"));
        
        permissionIds.forEach(permissionId -> {
            RolePermission newRolePermission = new RolePermission();
            newRolePermission.setRole(role);
            newRolePermission.setPermission(permissionRepository.findById(permissionId).orElseThrow(() -> new IllegalArgumentException("Permission not found")));
            rolePermissionRepository.save(newRolePermission);
        });     

        return rolePermissionRepository.findByRoleId(roleId);
    }
    
}
