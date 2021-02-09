package com.vs.authorizationService.setvice;

import com.vs.authorizationService.entity.User;
import com.vs.authorizationService.entity.UserData;

import java.util.List;
import java.util.Optional;

public interface UserDataService {

    List<UserData> findAllBy();
    Optional<UserData> findByIdRUserData(Long id);
    UserData findByUser(User user);

    void save(UserData userData);

    void dell(UserData userData);
    void dell(Long id);
    void deleteById(Long id);
}
