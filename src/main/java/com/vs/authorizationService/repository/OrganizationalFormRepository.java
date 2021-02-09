package com.vs.authorizationService.repository;

import com.vs.authorizationService.entity.OrganizationalForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganizationalFormRepository extends JpaRepository<OrganizationalForm,Integer> {

    List<OrganizationalForm> findAllBy();
    Optional<OrganizationalForm> findByIdOrganizationalForm(int id);
    Optional<OrganizationalForm> findByName(String name);
}
