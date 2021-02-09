package com.vs.authorizationService.repository;

import com.vs.authorizationService.entity.User;
import com.vs.authorizationService.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDataRepository extends JpaRepository<UserData,Long> {

    List<UserData> findAllBy();
    Optional<UserData> findByIdRUserData(Long id);
    UserData findByUser(User user);
    void deleteById(Long id);
}
