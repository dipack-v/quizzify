package com.quiz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.quiz.repository.QuestionRepository;
import com.quiz.repository.entity.QuestionEntity;


@SpringBootApplication
public class QuizzifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizzifyApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(QuestionRepository questionRepository) {
		return args -> {
			List<QuestionEntity> questionList =  new ArrayList<QuestionEntity> ();
			QuestionEntity question1 = new QuestionEntity(1L);
			question1.setQuestion("What is the previous version of HTML, prior to HTML5?");
			questionList.add(question1);
			
			questionRepository.save(questionList);
			
		};
	}
}
