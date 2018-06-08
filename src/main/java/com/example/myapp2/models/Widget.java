package com.example.myapp2.models;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
//import javax.persistence.ManyToOne;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//public class Widget {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int id;
//	private int size;
//	private int position;
//	private boolean ordered;
//	private String url;
//	private String text;
//	private String name;
//	private String widgetType;
//	
//	@ManyToOne
//	@JsonIgnore
//	private Lesson lesson;
//	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public int getSize() {
//		return size;
//	}
//	public void setSize(int size) {
//		this.size = size;
//	}
//	public int getPosition() {
//		return position;
//	}
//	public void setPosition(int position) {
//		this.position = position;
//	}
//	public boolean getOrdered() {
//		return ordered;
//	}
//	public void setOrdered(boolean ordered) {
//		this.ordered = ordered;
//	}
//	public String getText() {
//		return text;
//	}
//	public void setText(String text) {
//		this.text = text;
//	}
//	public String getUrl() {
//		return url;
//	}
//	public void setUrl(String url) {
//		this.url = url;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getWidgetType() {
//		return widgetType;
//	}
//	public void setWidgetType(String type) {
//		this.widgetType = type;
//	}
//	public Lesson getLesson() {
//		return lesson;
//	}
//	public void setLesson(Lesson lesson) {
//		this.lesson = lesson;
//	}
//}


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Widget {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String text;
	private String widgetType;
	@ManyToOne
	@JsonIgnore
	private Lesson lesson;
	public String getWidgetType() {
		return widgetType;
	}
	public void setWidgetType(String widgetType) {
		this.widgetType = widgetType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Lesson getLesson() {
		return lesson;
	}
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
}