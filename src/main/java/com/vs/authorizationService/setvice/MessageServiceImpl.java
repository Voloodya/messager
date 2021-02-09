package com.vs.authorizationService.setvice;

import com.vs.authorizationService.entity.Request;
import com.vs.authorizationService.entity.Message;
import com.vs.authorizationService.entity.User;
import com.vs.authorizationService.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;


    @Override
    public List<Message> findByUserResponse(User userResponse) {
        return messageRepository.findByUserResponse(userResponse);
    }

    @Override
    public Message findByIdMessage(int idMessage) {
        return messageRepository.findByIdMessage(idMessage);
    }

    @Override
    public List<Message> findAllBy() {
        return messageRepository.findAllBy();
    }

    @Override
    public List<Message> findByRequest(Request request) {
        return messageRepository.findByRequest(request);
    }

    @Override
    public boolean save(Message message) {
        boolean rezult=true;
        try{
            messageRepository.save(message);
        }catch (Exception e){
            rezult=false;
        }
        return rezult;
    }

    @Override
    public void saveListMessages(Request request, List<User> users) {

        for(int i=0;i<users.size();i++){
            save(Message.builder().request(request).userResponse(users.get(i)).build());
        }
    }

    @Override
    public boolean dell(Message message) {
        boolean rezult=true;
        try{
            messageRepository.delete(message);
        }catch (Exception e){
            rezult=false;
        }
        return rezult;
    }

    @Override
    public List<Message> findByResponseTextContaining(String textResponse) {
        return messageRepository.findByResponseTextContaining(textResponse);
    }
}
