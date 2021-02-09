package com.vs.authorizationService.setvice;

import com.vs.authorizationService.entity.Role;
import com.vs.authorizationService.repository.RoleRepository;
import com.vs.authorizationService.setvice.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<Role> findByIdRole(int id) {
        return roleRepository.findByIdRole(id);
    }

    @Override
    public List<Role> findAllBy() {
        return roleRepository.findAllBy();
    }

    @Override
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void dell(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public void deleteByIdRole(int id) {
        roleRepository.deleteByIdRole(id);
    }
}
