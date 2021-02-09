package com.vs.authorizationService.repository;

import com.vs.authorizationService.entity.TypeSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TypeSubjectRepository extends JpaRepository<TypeSubject,Integer> {

    List<TypeSubject> findAllBy();
    Optional<TypeSubject> findById(Integer integer);

    Optional<TypeSubject> findByName(String name);
    Optional<TypeSubject> findByIdTypeSubject(int id);
}
