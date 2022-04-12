package fr.afpa.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {


    /**
     * FAQ: How to inject properties file using Java annotations
     * Answer:
     * This solution will show you how inject values from a properties file using annotatons. The values will no longer be hard coded in the Java code.
     *
     * 1. Create a properties file to hold your properties. It will be a name value pair.
     *
     * New text file:  src/sport.properties
     *
     * foo.email=myeasycoach@luv2code.com
     * foo.team=Silly Java Coders
     * Note the location of the properties file is very important. It must be stored in src/sport.properties
     *
     * 2. Load the properties file in the XML config file.
     *
     * File: applicationContext.xml
     *
     * Add the following lines:
     *
     *     <context:property-placeholder location="classpath:sport.properties"/>
     *
     * This should appear just after the <context:component-scan .../> line
     *
     * 3. Inject the properties values into your Swim Coach: SwimCoach.java
     *
     *
     *
     * @Value("${foo.email}")
     * private String email;
     *
     * @Value("${foo.team}")
     * private String team;
     * ---
     *
     * DOWNLOAD FULL SOURCE CODE
     *
     * You can download entire code from here:
     *
     * - http://www.luv2code.com/downloads/spring-hibernate/spring-props-annotation-demo.zip
     */
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    /**
     * @Qualifier is a nice feature, but it is tricky when used with Constructors.
     *
     * The syntax is much different from other examples and not exactly intuitive.
     * Consider this the "deep end of the pool" when it comes to Spring configuration
     * You have to place the @Qualifier annotation inside of the constructor arguments.
     *
     * Here's an example from our classroom example.
     * I updated it to make use of constructor injection, with @Autowired and @Qualifier.
     * Make note of the code in bold below:
     *
     * @Autowired
     *     public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
     *     }
     *
     * https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-autowired-annotation-qualifiers
     * */

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

/**
 * You can use similar syntax with Setter Injection. You can use @Qualifier in method arguments line, such as
 * @Autowired
 *        public void setFortuneService(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
 *    }
 *
 * OR
 *
 * @Autowired
 *        @Qualifier("randomFortuneService")
 *    public void setFortuneService(FortuneService theFortuneService) {
 *    }
 *
 */
/**
    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
        System.err.println(">> TennisCoach: inside setter method");
    }

    @Autowired
    public void doSomeCrazyStuff(FortuneService fortuneService){
        this.fortuneService =fortuneService;
        System.err.println(">> TennisCoach: inside doSomeCrazyStuff method");
    }
*/


/**
 * Special Note about @PostConstruct and @PreDestroy Method Signatures
 *
 * I want to provide additional details regarding the method signatures of @PostContruct and @PreDestroy methods.
 *
 * Access modifier
 *
 * The method can have any access modifier (public, protected, private)
 *
 * Return type
 * The method can have any return type. However, "void' is most commonly used. If you give a return type just note that you will not be able to capture the return value. As a result, "void" is commonly used.
 *
 * Method name
 * The method can have any method name.
 *
 * Arguments
 * The method can not accept any arguments. The method should be no-arg.
 * */
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
    }
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println(">> TennisCoach: inside of doMyCleanupStuff()");
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
