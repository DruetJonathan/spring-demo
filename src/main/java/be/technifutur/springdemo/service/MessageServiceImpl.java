package be.technifutur.springdemo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private final List<String> messages = new ArrayList<>();
    @Override
    public String getLastMessage() {
        if (messages.isEmpty()){
            return null;
        }
        else {
            return messages.get(messages.size()-1);

        }
    }

    @Override
    public List<String> getAllMessage() {
        return new ArrayList<>(messages);
    }

    @Override
    public String getMessage(int index) {
        return messages.get(index);
    }

    @Override
    public void addMessage(String toAdd) {
        messages.add(toAdd);
    }

    @Override
    public void deleteMessage(int index) {
        messages.remove(index);
    }

    @Override
    public void changeMessage(int index, String newChaine) {
        messages.set(index,newChaine);
    }
}
