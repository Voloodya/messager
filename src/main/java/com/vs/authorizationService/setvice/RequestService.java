package com.vs.authorizationService.setvice;

import com.vs.authorizationService.entity.Request;
import com.vs.authorizationService.entity.User;

import java.util.List;
import java.util.Optional;

public interface RequestService {

    List<Request> findByUserRequest(User userRequest);
    Optional<Request> findByIdRequest(int idRequest);
    List<Request> findAllBy();
    boolean save (Request request);
    boolean dell (Request request);
    List<Request> findByRequestTextContaining(String textRequest);



}
