package fr.afpa.springdemo;

import org.springframework.beans.factory.annotation.Autowired;

public class SwimCoach implements Coach{

    private FortuneService fortuneService;


    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 100 meters as a warm up.";
    }

    @Override
    public String getDailyFortuen() {
        return fortuneService.getFortune();
    }
}
