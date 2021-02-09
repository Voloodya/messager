package com.vs.authorizationService.repository;

import com.vs.authorizationService.entity.User;

import java.util.List;

public interface UserCustomRepository {

    List<User> findByStatusCustomQuery(String status);
}
