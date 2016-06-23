package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.repository.QuestionRepository;
import com.quiz.repository.entity.QuestionEntity;

@RestController
public class QuestionController {
	@Autowired
	private QuestionRepository questionRepository;
	
	@RequestMapping(value="/questions", method = RequestMethod.GET)
    public List<QuestionEntity> getWines() throws Exception {
		 return questionRepository.findAll();
    }
	
	@RequestMapping(value="/questions/{id}", method = RequestMethod.GET)
    public QuestionEntity getWine(@PathVariable(value="id") Long id) {
		return questionRepository.findOne(id) ;
    }
	
	@RequestMapping(value="/questions", method = RequestMethod.POST)
    public QuestionEntity saveWine(@RequestBody QuestionEntity question) throws Exception {
		 return questionRepository.save(question);
    }
	
	@RequestMapping(value="/questions/{id}", method = RequestMethod.PUT)
    public QuestionEntity updateWine(@PathVariable(value="id") Long id, @RequestBody QuestionEntity question) throws Exception {
		return questionRepository.save(question);
    }
	
	@RequestMapping(value="/questions/{id}", method = RequestMethod.DELETE)
    public void deleteWine(@PathVariable(value="id") Long id) {
		questionRepository.delete(id);
    }
	
}




