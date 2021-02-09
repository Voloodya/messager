package com.vs.authorizationService.repository;

import com.vs.authorizationService.entity.Request;
import com.vs.authorizationService.entity.Message;
import com.vs.authorizationService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {

    List<Message> findByUserResponse(User UserResponse);
    Message findByIdMessage(int idRequest);
    List<Message> findAllBy();
    List<Message> findByRequest(Request request);

    @Query(value = "SELECT * FROM responses WHERE Response_text LIKE %:text%",nativeQuery = true)
    List<Message> findByResponseTextContaining(@Param("text") String textResponse);
}
