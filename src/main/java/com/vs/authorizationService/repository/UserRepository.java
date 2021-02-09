package com.vs.authorizationService.repository;

import com.vs.authorizationService.entity.Request;
import com.vs.authorizationService.entity.Status;
import com.vs.authorizationService.entity.User;
import com.vs.authorizationService.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>,UserCustomRepository {

    Optional<User> findById(Long id);
    Optional<User> findByUserName(String login);
    List<User> findAllBy();
    List<User> findByUserData(UserData userData);

    //@Query(value = "SELECT * FROM users WHERE Status=:status",nativeQuery = true)
    List<User> findByStatus(@Param("status")Status status);

}
