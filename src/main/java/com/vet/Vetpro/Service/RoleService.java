package com.vet.Vetpro.Service;

import com.vet.Vetpro.Models.Role;

import java.util.List;

public interface RoleService {

    public Role saveRole(Role role);

    public void deleteRole(long id);

    public Role findByIdRole(long id);

    public List<Role> findAllRole();
}
