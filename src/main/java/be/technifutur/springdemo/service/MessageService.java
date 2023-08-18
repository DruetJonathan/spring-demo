package be.technifutur.springdemo.service;

import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface MessageService {
     String getLastMessage();
     List<String> getAllMessage();
    String getMessage(int message);
    void addMessage(String toAdd);
    void deleteMessage(int index);
    void changeMessage(int index,String newChaine);

}
