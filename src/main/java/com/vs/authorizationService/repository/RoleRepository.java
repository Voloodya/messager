package com.vs.authorizationService.repository;

import com.vs.authorizationService.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByIdRole(int id);
    List<Role> findAllBy();
    Optional<Role> findByName(String name);

    void deleteByIdRole(int id);
}
