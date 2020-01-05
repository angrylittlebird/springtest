package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import soundsystem.Person;

/**
 * @Author: ZHANG
 * @Date: 2020/1/4
 * @Description:    演示占位符 ${}
 */
@Configuration
@PropertySource("classpath:app.properties")
public class PlaceHolderConfig {
//    @Bean
//    public PropertySourcesPlaceholderConfigurer placeholder(){
//        //它能够基于Spring Environment及其属性源来解析占位符
//        return new PropertySourcesPlaceholderConfigurer();
//    }

    @Bean
    public Person person(@Value("${person.name}") String name,@Value("${person.age}") int age){
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        return person;
    }
}
