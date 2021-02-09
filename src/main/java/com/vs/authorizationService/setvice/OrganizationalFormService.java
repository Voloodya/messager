package com.vs.authorizationService.setvice;

import com.vs.authorizationService.entity.OrganizationalForm;

import java.util.List;
import java.util.Optional;

public interface OrganizationalFormService {
    List<OrganizationalForm> findAllBy();
    Optional<OrganizationalForm> findByIdOrganizationalForm(int id);
    Optional<OrganizationalForm> findByName(String name);
}
