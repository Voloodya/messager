package com.vs.authorizationService.setvice;


import com.vs.authorizationService.entity.Role;
import com.vs.authorizationService.entity.Status;
import com.vs.authorizationService.entity.User;
import com.vs.authorizationService.entity.UserData;
import com.vs.authorizationService.repository.RoleRepository;
import com.vs.authorizationService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    //Данные из application.properties
    @Value("${app.service.userservice.greeting}")
    private String greeting;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();


    @Override
    public boolean save(User user) {
        try{
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles=new HashSet<Role>();
        //Присваиваем роль по имолчанию "User"
        roles.add(roleRepository.getOne(2));
        user.setRoles(roles);

        userRepository.save(user);
        return  true; }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUserName(String login) {
        return userRepository.findByUserName(login);
    }

    @Override
    public List<User> findAllBy() {
        return userRepository.findAllBy();
    }

    @Override
    public List<User> findByUserData(UserData userData) {
        return userRepository.findByUserData(userData);
    }

    @Override
    public List<User> findByStatus(Status status) {
        return userRepository.findByStatus(status);
    }

    @Override
    public List<User> findByStatusCustomQuery(String status) {
        return userRepository.findByStatusCustomQuery(status);
    }

    @Override
    public String greetUser(User user) {
        return greeting+" "+user.getUserData().getFullNameCompany();
    }

    @Override
    public void delete(long idUser) {
        userRepository.deleteById(idUser);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
