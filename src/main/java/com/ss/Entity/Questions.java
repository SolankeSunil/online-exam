package com.ss.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Questions {
	@Id
	private int qno;
	private String question;
	private String opetion1;
	private String opetion2;
	private String opetion3;
	private String opetion4;
	private String answer;
	private String subject;

	public Questions() {

	}

	

	public Questions(int qno, String question, String opetion1, String opetion2, String opetion3, String opetion4,
			String answer, String subject) {
		super();
		this.qno = qno;
		this.question = question;
		this.opetion1 = opetion1;
		this.opetion2 = opetion2;
		this.opetion3 = opetion3;
		this.opetion4 = opetion4;
		this.answer = answer;
		this.subject = subject;
	}



	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOpetion1() {
		return opetion1;
	}

	public void setOpetion1(String opetion1) {
		this.opetion1 = opetion1;
	}

	public String getOpetion2() {
		return opetion2;
	}

	public void setOpetion2(String opetion2) {
		this.opetion2 = opetion2;
	}

	public String getOpetion3() {
		return opetion3;
	}

	public void setOpetion3(String opetion3) {
		this.opetion3 = opetion3;
	}

	public String getOpetion4() {
		return opetion4;
	}

	public void setOpetion4(String opetion4) {
		this.opetion4 = opetion4;
	}

	public String getAnswer() {                  
		return answer;                           
	}                                            
                                                 
	public void setAnswer(String answer) {       
		this.answer = answer;                    
	}                                            
                                                 
	public String getSubject() {                 
		return subject;                          
	}                                            
                                                 
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getQno() {
		return qno;
	}

	public void setQno(int qno) {
		this.qno = qno;
	}



	@Override
	public String toString() {
		return "Questions [qno=" + qno + ", question=" + question + ", opetion1=" + opetion1 + ", opetion2=" + opetion2
				+ ", opetion3=" + opetion3 + ", opetion4=" + opetion4 + ", answer=" + answer + ", subject=" + subject
				+ "]";
	}

	

}
