package fr.afpa.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from spring container
        SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

        //call a method on the bean
        System.out.println(theCoach.getDailyWorkout());

        //call method to get daily fortune
        System.err.println(theCoach.getDailyFortuen());


        //call getters
        System.err.println("email >> " + theCoach.getEmail());
        System.err.println("team >> " + theCoach.getTeam());

        //close the context
        context.close();
    }
}
