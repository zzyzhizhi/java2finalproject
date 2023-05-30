package cse.java2.project;

import cse.java2.project.repository.MyRepository;
import cse.java2.project.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * This is the main class of the Spring Boot application.
 */

@SpringBootApplication
@ComponentScan("cse.java2.project.repository") // 包路径
@ComponentScan("cse.java2.project.service") // 包路径
@EnableJpaRepositories(basePackages = "cse.java2.project.repository")
public class Application {
    @Autowired
    private MyRepository myRepository ;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @PostConstruct
    public void init(){
        QuestionService questionService = new QuestionService(myRepository);
        try {
            questionService.saveQuestionsFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
