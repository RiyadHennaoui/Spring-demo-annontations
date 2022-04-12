package fr.afpa.springdemo;

import org.springframework.stereotype.Component;

/**
 * In general, when using Annotations, for the default bean name, Spring uses the following rule.
 *
 * If the annotation's value doesn't indicate a bean name, an appropriate name will be built based on the short name of the class
 * (with the first letter lower-cased).
 *
 * For example:
 *
 * HappyFortuneService --> happyFortuneService
 *
 *However, for the special case of when BOTH the first and second characters of the class name are upper case, then the name is NOT converted.
 *
 * For the case of RESTFortuneService
 *
 * RESTFortuneService --> RESTFortuneService
 *
 * As always, you can specify a name for your bean. with
 *
 * @Compenent("foo")
 *
 * https://docs.oracle.com/javase/8/docs/api/java/beans/Introspector.html#decapitalize(java.lang.String)
 * */
@Component
public class RESTFortuneService implements FortuneService{



    @Override
    public String getFortune() {
        return null;
    }
}
