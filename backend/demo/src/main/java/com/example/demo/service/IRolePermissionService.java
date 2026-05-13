package com.example.demo.service;

import java.util.List;

import com.example.demo.model.RolePermission;

public interface IRolePermissionService {
    List<RolePermission> addPermissionsToRole(Integer roleId, List<Integer> permissionIds);
}
