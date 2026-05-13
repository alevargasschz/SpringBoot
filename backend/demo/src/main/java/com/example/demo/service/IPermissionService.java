package com.example.demo.service;


import java.util.List;

import com.example.demo.model.Permission;


public interface IPermissionService {
    List<Permission> findByRolePermissions_Role_Users_Id (Integer userId);
}
