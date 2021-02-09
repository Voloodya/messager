package com.vs.authorizationService.setvice;

import com.vs.authorizationService.entity.Status;
import com.vs.authorizationService.entity.User;
import com.vs.authorizationService.entity.UserData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findById(Long id);
    Optional<User> findByUserName(String login);
    List<User> findAllBy();
    boolean save (User user);
    List<User> findByUserData(UserData userData);

    List<User> findByStatus(Status status);

    List<User> findByStatusCustomQuery(String status);

    String greetUser(User user);

    void delete(long idUser);
    void delete(User user);
}
