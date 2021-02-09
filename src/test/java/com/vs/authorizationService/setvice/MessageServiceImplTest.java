package com.vs.authorizationService.setvice;

import com.vs.authorizationService.entity.Request;
import com.vs.authorizationService.entity.Message;
import com.vs.authorizationService.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MessageServiceImplTest {

    @Autowired
    private MessageService messageService;
    @Autowired
    private RequestService requestService;
    @Autowired
    private UserService userService;

    private final Integer id_message=2;
    private final Integer id_request=1;
    private static final Long id_user= Long.valueOf(3);


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findByUserResponse() {
        Optional<User> user=userService.findById(id_user);
        List<Message> respons =null;
        if(user.isPresent()){
            respons = messageService.findByUserResponse(user.get());}
        assertTrue(!respons.isEmpty());
    }

    @Test
    void findByIdResponse() {
        Message message = messageService.findByIdMessage(id_message);
        assertTrue(message.getIdMessage()==id_message);
    }

    @Test
    void findAllBy() {
       List<Message> respons = messageService.findAllBy();
        assertTrue(!respons.isEmpty());
    }

    @Test
    void findByRequest() {
        Optional<Request> request=requestService.findByIdRequest(id_request);
        List<Message> message =null;
        if(request.isPresent()){
            message = messageService.findByRequest(request.get());
        }
        assertTrue(!message.isEmpty() && message.get(0).getRequest().equals(request.get()));
    }

    @Test
    void save() {
    }

    @Test
    void dell() {
    }

    @Test
    void findByResponseTextContaining() {
    }
}