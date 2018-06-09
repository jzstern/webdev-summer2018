package com.example.myapp2.models.Questions;

import javax.persistence.Entity;

@Entity
public class TrueFalseQuestion extends Question {
	private boolean isTrue;
	public boolean isTrue() {
		return isTrue;
	}
	public void setTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}
}