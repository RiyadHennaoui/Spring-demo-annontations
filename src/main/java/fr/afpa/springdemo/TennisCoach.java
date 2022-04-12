package fr.afpa.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    public TennisCoach() {
        System.err.println(">> TennisCoach: inside default constructor");
    }

    /**
     * @Autowired is no longer necessary if the target bean only defines one constructor.
     * see the doc https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-autowired-annotation
     * */
//    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }


//    @Autowired
//    public void setFortuneService(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//        System.err.println(">> TennisCoach: inside setter method");
//    }

    @Autowired
    public void doSomeCrazyStuff(FortuneService fortuneService){
        this.fortuneService =fortuneService;
        System.err.println(">> TennisCoach: inside doSomeCrazyStuff method");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortuen() {
        return fortuneService.getFortune();
    }
}
