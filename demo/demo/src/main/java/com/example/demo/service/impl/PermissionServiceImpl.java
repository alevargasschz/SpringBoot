package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Permission;
import com.example.demo.repository.IPermissionRepository;
import com.example.demo.service.IPermissionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements IPermissionService {
    private IPermissionRepository permissionRepository;

    @Override
    public List<Permission> findByRolePermissions_Role_Users_Id(Integer userId) {
        return permissionRepository.findByRolePermissions_Role_Users_Id(userId);
    }
}
