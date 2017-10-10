/*
 * Klasa MessageDB predstavlja klasu u koju se skladište svi Message objekti
 */
package model.dto;

import java.util.ArrayList;

public class MessageDB {
	
	// Atribut se zove messages, tip atributa ArrayList
	/*
	 * Šta je ArrayList?
	 * To je lista nasih objekata, u ovom slucaju objekata tipa Message
	 * 
	 */
	private ArrayList<Message> messages = new ArrayList<Message>();

	/* Getter */
	public ArrayList<Message> getMessages() {
		return messages;
	}
	
	// Setter
	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}
}
