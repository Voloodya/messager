package com.vs.authorizationService.setvice;

import com.vs.authorizationService.entity.Request;
import com.vs.authorizationService.entity.User;
import com.vs.authorizationService.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Override
    public List<Request> findByUserRequest(User userRequest) {
        return requestRepository.findByUserRequest(userRequest);
    }

    @Override
    public Optional<Request> findByIdRequest(int idRequest) {
        return requestRepository.findByIdRequest(idRequest);
    }

    @Override
    public List<Request> findAllBy() {
        return requestRepository.findAllBy();
    }

    @Override
    public boolean save(Request request) {
        boolean rezult=true;
        try{
            requestRepository.save(request);
        }catch (Exception e){
            rezult=false;
        }
        return rezult;
    }

    @Override
    public boolean dell(Request request) {
        boolean rezult=true;
        try{
            requestRepository.delete(request);
        }catch (Exception e){
            rezult=false;
        }
        return rezult;
    }

    @Override
    public List<Request> findByRequestTextContaining(String textRequest) {
        return requestRepository.findByRequestTextContaining(textRequest);
    }
}
