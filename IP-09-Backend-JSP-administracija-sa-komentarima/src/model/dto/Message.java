/*
 * Klasa Message koristi se za skladištenje vijesti
 * - klasa nema konstruktor
 * - klasa nema dodatne funkcije
 */
package model.dto;

import java.util.Date;

public class Message {
	
	// Atributi klase Message
	private Date date = null;
	private String title = null;
	private String content = null;
	private String author = null;
	private String category = null;
	
	/*
	 * Getteri i Setteri
	 */
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
