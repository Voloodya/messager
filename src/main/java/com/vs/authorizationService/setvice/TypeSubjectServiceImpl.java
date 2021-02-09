package com.vs.authorizationService.setvice;

import com.vs.authorizationService.entity.TypeSubject;
import com.vs.authorizationService.repository.TypeSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeSubjectServiceImpl implements TypeSubjectService {

    @Autowired
    private TypeSubjectRepository typeSubjectRepository;

    @Override
    public List<TypeSubject> findAllBy() {
        return typeSubjectRepository.findAllBy();
    }

    @Override
    public Optional<TypeSubject> findByName(String name) {
        return typeSubjectRepository.findByName(name);
    }

    @Override
    public Optional<TypeSubject> findByIdTypeSubject(int id) {
        return typeSubjectRepository.findByIdTypeSubject(id);
    }

    @Override
    public void save(TypeSubject typeSubject) {
        typeSubjectRepository.save(typeSubject);

    }
}
