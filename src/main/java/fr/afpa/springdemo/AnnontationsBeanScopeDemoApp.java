package fr.afpa.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnontationsBeanScopeDemoApp {

    public static void main(String[] args) {
        //load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrive bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        //check if they are the same
        boolean result = (theCoach == alphaCoach);

        // print the result
        System.out.println( "Pointing to the same object : " + result);
        System.out.println( "Memory location of theCoach : " + theCoach);
        System.out.println( "Memory location of alphaCoach : " + alphaCoach);

        //close context
        context.close();
    }
}
