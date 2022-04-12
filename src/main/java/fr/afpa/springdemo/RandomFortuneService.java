package fr.afpa.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{

    private String[] data = {
            "Beware of the wolf in sheep's clothing",
            "Diligence is mother of good luck",
            "The journey is reward"
    };

    private Random myRandom = new Random();

    @Override
    public String getFortune() {
        int index = myRandom.nextInt(data.length);
        String theFortune = data[index];
        return theFortune;
    }
}
