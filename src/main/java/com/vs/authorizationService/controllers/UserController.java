package com.vs.authorizationService.controllers;

import com.vs.authorizationService.DTOentity.UserDTO;
import com.vs.authorizationService.entity.User;
import com.vs.authorizationService.setvice.MessageService;
import com.vs.authorizationService.setvice.RequestService;
import com.vs.authorizationService.setvice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private RequestService requestService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;

    private String repeatPasswordDontMatch="Passwords";

    @GetMapping("/")
    public String getStartPage()
    {
        return  "UIS56.html";
    }

    @GetMapping("/UIS56")
    public String getMainPage()
    {
        return  "UIS56.html";
    }

    @GetMapping("/home")
    public String getMessages()
    {
      //  Optional<Request> request=requestService.findByIdRequest(1);
        return  "home.html";
    }

    @GetMapping("/login")
    public String getlogin()
    {
        return  "login";
    }

    @PostMapping("/login")
    public String login()
    {
        return  "login";
    }


    @GetMapping("/registration")
    public String getRegistration(Model model)
    {
        model.addAttribute("user", new UserDTO());

        return  "registration";
    }

    @PostMapping("/registration")
    public String registrationNewUser(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            //Остаемся на той же странице
            return "/registration";
        }
        if(!userDTO.getRepeatPassword().equals(userDTO.getPassword())){
            //Генерируем ошибку
            bindingResult.rejectValue("password",repeatPasswordDontMatch+"не совпадают!");
            return "/registration";
        }
        return "/registration:/login";
    }


    @GetMapping("/accessDenied")
    public String getAccessDenied()
    {
        return  "accessDenied";
    }


    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){

        return null;
    }
}
