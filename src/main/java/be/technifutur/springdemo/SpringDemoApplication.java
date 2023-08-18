package be.technifutur.springdemo;

import be.technifutur.springdemo.other.DemoIOC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringDemoApplication.class, args);
        Scanner bean = run.getBean(Scanner.class);
        DemoIOC demoIOC = run.getBean(DemoIOC.class);
    }

}
