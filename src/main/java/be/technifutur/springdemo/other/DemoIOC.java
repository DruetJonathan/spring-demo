package be.technifutur.springdemo.other;

import org.springframework.stereotype.Component;

@Component
//Connaitre la classe et spring sait qu'elle doit être instancié
public class DemoIOC {

    public DemoIOC() {
        System.out.println("Instanciation de DemoIOC");
    }
}
