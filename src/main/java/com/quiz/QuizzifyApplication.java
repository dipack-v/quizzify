package com.quiz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.quiz.repository.QuestionRepository;
import com.quiz.repository.entity.QuestionEntity;
import com.quiz.repository.entity.AnswerEntity;


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
			question1.setQuestion("Inside which HTML element do we put the JavaScript?");
			question1.addAnswer(new AnswerEntity(1L,"<scripting>"));
			question1.addAnswer(new AnswerEntity(2L,"<script>"));
			questionList.add(question1);
			
			QuestionEntity question2 = new QuestionEntity(2L);
			question2.setQuestion("What does HTML stand for?");
			question2.addAnswer(new AnswerEntity(3L,"Hyper Text Markup Language"));
			question2.addAnswer(new AnswerEntity(4L,"Hyper Media Language"));
			questionList.add(question2);
		
			questionRepository.save(questionList);
			
		};
	}
}
