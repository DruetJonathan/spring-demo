package be.technifutur.springdemo.controller;

import be.technifutur.springdemo.service.MessageService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.HEAD;

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
    public ResponseEntity<String> getLastMessage(){
        return ResponseEntity
                .status(HttpStatus.I_AM_A_TEAPOT)
                .header("headerName","value1")
                .body(messageService.getLastMessage());
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

    @RequestMapping(method = HEAD,path = "/test/Header")
    public void testGest(@RequestHeader String testHeader){
        System.out.println(testHeader);
    }
}
