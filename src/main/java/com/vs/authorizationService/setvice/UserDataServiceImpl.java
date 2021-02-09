package com.vs.authorizationService.setvice;

import com.vs.authorizationService.entity.User;
import com.vs.authorizationService.entity.UserData;
import com.vs.authorizationService.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDataServiceImpl implements UserDataService {

    @Autowired
    private  UserDataRepository userDataRepository;

    @Override
    public List<UserData> findAllBy() {
        return userDataRepository.findAllBy();
    }

    @Override
    public Optional<UserData> findByIdRUserData(Long id) {
        return userDataRepository.findByIdRUserData(id);
    }

    @Override
    public UserData findByUser(User user) {
        return userDataRepository.findByUser(user);
    }

    @Override
    public void save(UserData userData) {
        userDataRepository.save(userData);
    }

    @Override
    public void dell(UserData userData) {
        userDataRepository.delete(userData);

    }

    @Override
    public void dell(Long id) {
        userDataRepository.deleteById(id);
    }

    @Override
    public void deleteById(Long id) {
        userDataRepository.deleteById(id);
    }
}
