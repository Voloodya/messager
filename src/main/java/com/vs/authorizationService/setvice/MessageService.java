package com.vs.authorizationService.setvice;

import com.vs.authorizationService.entity.Request;
import com.vs.authorizationService.entity.Message;
import com.vs.authorizationService.entity.User;

import java.util.List;
import java.util.Optional;

public interface MessageService {

    List<Message> findByUserResponse(User UserResponse);
    Message findByIdMessage(int idMessage);
    List<Message> findAllBy();
    List<Message> findByRequest(Request request);
    boolean save(Message message);
    void saveListMessages (Request request, List<User> users);
    boolean dell(Message message);

    List<Message> findByResponseTextContaining(String textResponse);


}
