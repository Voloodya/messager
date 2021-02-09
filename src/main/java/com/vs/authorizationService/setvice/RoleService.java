package com.vs.authorizationService.setvice;

import com.vs.authorizationService.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    Optional<Role> findByIdRole(int id);
    List<Role> findAllBy();
    Optional<Role> findByName(String name);

    void save(Role role);
    void dell(Role role);
    void deleteByIdRole(int id);
}
