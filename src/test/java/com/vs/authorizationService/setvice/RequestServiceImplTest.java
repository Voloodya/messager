package com.vs.authorizationService.setvice;

import com.vs.authorizationService.entity.Request;
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
class RequestServiceImplTest {

    @Autowired
    private RequestService requestService;
    @Autowired
    private UserService userService;

    private final Integer id_request=2;
    private static final Long id_user= Long.valueOf(1);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findByUserRequest() {
        Optional<User> user=userService.findById(id_user);
        List<Request> request=null;
        if(user.isPresent()){
         request=requestService.findByUserRequest(user.get());}
        assertTrue(!request.isEmpty());
    }

    @Test
    void findByIdRequest() {
        Optional<Request> request=requestService.findByIdRequest(id_request);
        assertTrue(request.isPresent());

    }

    @Test
    void findAllBy() {
    }

    @Test
    void save() {
    }

    @Test
    void dell() {
    }

    @Test
    void findByRequestTextContaining() {
    }
}