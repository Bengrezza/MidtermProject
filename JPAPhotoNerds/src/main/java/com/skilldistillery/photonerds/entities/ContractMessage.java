package com.skilldistillery.photonerds.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@ManyToOne
	@JoinColumn(name = "contract_id")
	private Contract contract;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

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

	public void setMessage(String message) {
		this.message = message;
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

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(contract, id, message, messageDate, reply, user);
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
		return Objects.equals(contract, other.contract) && id == other.id && Objects.equals(message, other.message)
				&& Objects.equals(messageDate, other.messageDate) && Objects.equals(reply, other.reply)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "ContractMessage [id=" + id + ", message=" + message + ", messageDate=" + messageDate + ", reply="
				+ reply + ", contract=" + contract + ", user=" + user + "]";
	}

}
