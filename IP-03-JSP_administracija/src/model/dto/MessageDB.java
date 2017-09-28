package model.dto;

import java.util.ArrayList;

public class MessageDB {
	
	private ArrayList<Message> messages = new ArrayList<Message>();

	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}

}
