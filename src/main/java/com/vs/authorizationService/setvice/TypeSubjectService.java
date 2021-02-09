package com.vs.authorizationService.setvice;

import com.vs.authorizationService.entity.TypeSubject;

import java.util.List;
import java.util.Optional;

public interface TypeSubjectService {

    List<TypeSubject> findAllBy();
    Optional<TypeSubject> findByName(String name);
    Optional<TypeSubject> findByIdTypeSubject(int id);
    void save (TypeSubject typeSubject);
}
