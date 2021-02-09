package com.vs.authorizationService.repository;

import com.vs.authorizationService.entity.Request;
import com.vs.authorizationService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequestRepository extends JpaRepository<Request,Integer> {

    List<Request> findByUserRequest(User userRequest);
    Optional<Request> findByIdRequest(Integer idRequest);
    List<Request> findAllBy();

    @Query(value="SELECT * FROM requests WHERE Request_text LIKE %:text%",nativeQuery = true)
    List<Request> findByRequestTextContaining(@Param("text") String textRequest);

}
