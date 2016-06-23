package com.quiz.repository.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class AnswerEntity {
	@Id
	@GeneratedValue
    private Long id;
	private String answer;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="question_id", insertable=false, updatable=false)
	@JsonIgnore
	private QuestionEntity question;
	public AnswerEntity() {
		super();
	}	
	public AnswerEntity(Long id, String answer) {
		super();
		this.id = id;
		this.answer = answer;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	

}
