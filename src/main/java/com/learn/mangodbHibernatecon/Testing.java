package com.learn.mangodbHibernatecon;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Indexed;

@Entity
@Indexed
@Table(name="test")
public class Testing{  
//Sample class for testing
	@Id
	private String id;
	
	@Column(name="book")
	private String book;
	
	@Column(name="author")
	private String author;

	public Testing(){
		
	}
	public Testing(String book, String author, String id){
		this.book = book;
		this.author = author;
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}