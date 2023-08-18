package be.technifutur.springdemo.controller;

import be.technifutur.springdemo.service.MessageService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class DemoController {
    private String message;
    private final MessageService messageService;

    public DemoController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello world";
    }

    @GetMapping("/addition")
    public Integer add(@RequestParam("membreA") int a, @RequestParam("membreB") int b){
        return a+b;
    }
    @GetMapping("/message/{index:[0-9]+]}")
    public String getMessage(@PathVariable int index){
        return this.messageService.getMessage(index);
    }
    @PutMapping("/message/{index:[0-9]+}")
    public void changeMessage(@RequestBody String message, @PathVariable int index){
        this.messageService.changeMessage(index,message);
    }
    @GetMapping("/message/last")
    public String getLastMessage(){
        return this.messageService.getLastMessage();
    }
    @PostMapping({"/message","/message/add"})
    public void addMessage(@RequestBody String message){
        this.messageService.addMessage(message);
    }
    @DeleteMapping("/message/{index:[0-9]+}")
    public void deleteMessage(@PathVariable("index") int index){
        this.messageService.deleteMessage(index);
    }
    @GetMapping("/message/all")
    public List<String> getMessages(){
        return this.messageService.getAllMessage();
    }
}
