package com.quiz.repository.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.hateoas.ResourceSupport;

@Entity
public class QuestionEntity {
	@Id
	@GeneratedValue
    private Long id;
    private String question;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="question")
	//@JoinColumn(name="question_id")
    private List<AnswerEntity> answers = new ArrayList<AnswerEntity>(0);
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
	
	public List<AnswerEntity> getAnswers() {
		return answers;
	}
	public void setAnswers(List<AnswerEntity> answers) {
		this.answers = answers;
	}
	
    public void addAnswer(AnswerEntity answer) {
    	answers.add(answer);
    	answer.setQuestion(this);
    }
 
    public void removeAnswer(AnswerEntity answer) {
    	answers.remove(answer);
        answer.setQuestion(this);
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuestionEntity other = (QuestionEntity) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}
	
	

}
