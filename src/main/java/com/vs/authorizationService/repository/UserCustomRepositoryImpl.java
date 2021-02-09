package com.vs.authorizationService.repository;

import com.vs.authorizationService.entity.User;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;


public class UserCustomRepositoryImpl implements UserCustomRepository{

    private  final EntityManager entityManager;

    public UserCustomRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<User> findByStatusCustomQuery(String status) {
        return null;
    }
}
