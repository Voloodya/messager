package com.vs.authorizationService.controllers;

/**
 *Обработчик URL с помощью традиционной аннотации @RequestMapping:
 * @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
 *
 * Новый подход позволяет сократить это до:
 * @GetMapping("/get/{id}")
 *
 * В Spring поддерживает пять типов встроенных аннотаций для обработки различных типов входящих методов HTTP-запросов
 * (GET, POST, PUT, DELETE и PATCH):
 * @GetMapping
 * @PostMapping
 * @PutMapping
 * @DeleteMapping
 * @PatchMapping
 *
 * @autor vladimir.s
 * @version 1.0
 */

import com.vs.authorizationService.DTOentity.UserDTO;
import com.vs.authorizationService.entity.Role;
import com.vs.authorizationService.entity.Status;
import com.vs.authorizationService.entity.User;
import com.vs.authorizationService.entity.UserData;
import com.vs.authorizationService.setvice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/item")
public class AdminController {

    @Autowired
    private RequestService requestService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserDataService userDataService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private TypeSubjectService typeSubjectService;
    @Autowired
    private  OrganizationalFormService organizationalFormService;

    // consumes - формат принимаемого значения; produces - формат возвращаемого значения
    @PostMapping(path ="/add" ,consumes = "application/json", produces = "application/json")
    public Long createUser(@RequestBody UserDTO userDTO){

        UserData userData=UserData.builder().INN(userDTO.getINN()).fullNameCompany(userDTO.getFullNameCompany()).typeSubject(typeSubjectService.findByName(userDTO.getTypeSubject()).get())
                .organizationalForm(organizationalFormService.findByName(userDTO.getOrganizationalForm()).get()).build();
        userDataService.save(userData);
        Set<Role> roles=new HashSet<Role>();
        roles.add(roleService.findByIdRole(2).get());
        Date date=new Date();
        User user=User.builder().userData(userData).createdDate(date).email(userDTO.getEmail()).firstName(userDTO.getFirstName()).lastName(userDTO.getLastName())
                .userName(userDTO.getUserName()).password(userDTO.getPassword()).roles(roles).status(Status.ACTIVE).wordCoder(userDTO.getWordCoder()).build();
        userService.save(user);
        return user.getIdUser();
    }

    @GetMapping(path = "/users", produces = "application/json")
    public List<User> findAllUsers(){
        List<User> users=userService.findAllBy();
        return  users;
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteUser(@PathVariable("id") long id){
        try{
            userService.delete(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
