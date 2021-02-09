package com.vs.authorizationService.DTOentity;

import com.vs.authorizationService.entity.OrganizationalForm;
import com.vs.authorizationService.entity.Status;
import com.vs.authorizationService.entity.TypeSubject;
import com.vs.authorizationService.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


public class UserDTO {

    private String userName;
    private String password;
    private String repeatPassword;

    private String wordCoder;

    private String email;

    private String firstName;

    private String lastName;

    private String INN;

    private String fullNameCompany;

    private String typeSubject;

    private String organizationalForm;

    public UserDTO() {
    }


    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public String getWordCoder() {
        return wordCoder;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getINN() {
        return INN;
    }

    public String getFullNameCompany() {
        return fullNameCompany;
    }

    public String getTypeSubject() {
        return typeSubject;
    }

    public String getOrganizationalForm() {
        return organizationalForm;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public void setWordCoder(String wordCoder) {
        this.wordCoder = wordCoder;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public void setFullNameCompany(String fullNameCompany) {
        this.fullNameCompany = fullNameCompany;
    }

    public void setTypeSubject(String typeSubject) {
        this.typeSubject = typeSubject;
    }

    public void setOrganizationalForm(String organizationalForm) {
        this.organizationalForm = organizationalForm;
    }
}
