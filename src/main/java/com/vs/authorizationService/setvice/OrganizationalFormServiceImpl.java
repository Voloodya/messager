package com.vs.authorizationService.setvice;

import com.vs.authorizationService.entity.OrganizationalForm;
import com.vs.authorizationService.repository.OrganizationalFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationalFormServiceImpl implements OrganizationalFormService {

    @Autowired
    private OrganizationalFormRepository organizationalFormRepository;

    @Override
    public List<OrganizationalForm> findAllBy() {
        return organizationalFormRepository.findAllBy();
    }

    @Override
    public Optional<OrganizationalForm> findByIdOrganizationalForm(int id) {
        return organizationalFormRepository.findByIdOrganizationalForm(id);
    }

    @Override
    public Optional<OrganizationalForm> findByName(String name) {
        return organizationalFormRepository.findByName(name);
    }
}
