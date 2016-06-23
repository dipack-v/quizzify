package com.quiz.repository.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class QuestionEntity {
	@Id
	@GeneratedValue
    private Long id;
    private String question;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="question_id")
    private Set<AnswerEntity> answers = new HashSet<AnswerEntity>(0);
    private String answer;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public Set<AnswerEntity> getAnswers() {
		return answers;
	}
	public void setAnswers(Set<AnswerEntity> answers) {
		this.answers = answers;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public QuestionEntity() {}
	public QuestionEntity(Long id) {
		super();
		this.id = id;
	
	}
	@Override
	public String toString() {
		return "QuestionEntity [id=" + id + ", question=" + question  + "]";
	}

}
