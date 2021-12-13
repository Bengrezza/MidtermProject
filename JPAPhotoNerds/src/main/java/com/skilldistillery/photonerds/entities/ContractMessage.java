package com.skilldistillery.photonerds.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contract_message")
public class ContractMessage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "message")
	private String message;
	@Column(name = "message_date")
	private LocalDateTime messageDate;
	@Column(name = "in_reply_to")
	private Integer reply;
	
	public ContractMessage() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String messsage) {
		this.message = messsage;
	}

	public LocalDateTime getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(LocalDateTime messageDate) {
		this.messageDate = messageDate;
	}

	public Integer getReply() {
		return reply;
	}

	public void setReply(Integer reply) {
		this.reply = reply;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, messageDate, message, reply);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContractMessage other = (ContractMessage) obj;
		return id == other.id && Objects.equals(messageDate, other.messageDate)
				&& Objects.equals(message, other.message) && reply == other.reply;
	}

	@Override
	public String toString() {
		return "ContractMessage [id=" + id + ", messsage=" + message + ", messageDate=" + messageDate + ", reply="
				+ reply + "]";
	}
	
	

}
