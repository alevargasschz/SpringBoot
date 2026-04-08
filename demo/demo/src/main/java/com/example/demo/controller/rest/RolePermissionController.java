package com.example.demo.controller.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RolePermission;
import com.example.demo.service.IRolePermissionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/role-permissions")
@RequiredArgsConstructor
public class RolePermissionController {
    private final IRolePermissionService rolePermissionService;

    @GetMapping
    public List<RolePermission> addPermissionsToRole() {
        return rolePermissionService.addPermissionsToRole(2, List.of(3, 40));
    }
}
