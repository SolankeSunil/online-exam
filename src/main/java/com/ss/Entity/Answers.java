package com.ss.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Answers {
	@Id
	private int qno ;
	private String question;
	private String yourAnswer;
	private String currectAnswer;
	public Answers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answers(int qno, String question, String yourAnswer, String currectAnswer) {
		super();
		this.qno = qno;
		this.question = question;
		this.yourAnswer = yourAnswer;
		this.currectAnswer = currectAnswer;
	}
	public int getQno() {
		return qno;
	}
	public void setQno(int qno) {
		this.qno = qno;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getYourAnswer() {
		return yourAnswer;
	}
	public void setYourAnswer(String yourAnswer) {
		this.yourAnswer = yourAnswer;
	}
	public String getCurrectAnswer() {
		return currectAnswer;
	}
	public void setCurrectAnswer(String currectAnswer) {
		this.currectAnswer = currectAnswer;
	}
	@Override
	public String toString() {
		return "Answers [qno=" + qno + ", question=" + question + ", yourAnswer=" + yourAnswer + ", currectAnswer="
				+ currectAnswer + "]";
	} 
    


}
