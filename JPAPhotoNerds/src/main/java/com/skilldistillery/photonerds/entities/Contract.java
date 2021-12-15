package com.skilldistillery.photonerds.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Contract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "location")
	private String location;
	@Column(name = "event_start")
	private LocalDateTime eventStart;
	@Column(name = "event_end")
	private LocalDateTime eventEnd;
	@Column(name = "photos_deliver_by")
	private LocalDate photoDeliveryBy;
	@Column(name = "closed")
	private int closed;

	@ManyToMany
	@JoinTable(name = "contract_has_photographer", joinColumns = @JoinColumn(name = "contract_id"), inverseJoinColumns = @JoinColumn(name = "photographer_id"))
	private List<Photographer> photographers;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "contract")
	private List<ContractMessage> contractMessages;

	public Contract() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDateTime getEventStart() {
		return eventStart;
	}

	public void setEventStart(LocalDateTime eventStart) {
		this.eventStart = eventStart;
	}

	public LocalDateTime getEventEnd() {
		return eventEnd;
	}

	public void setEventEnd(LocalDateTime eventEnd) {
		this.eventEnd = eventEnd;
	}

	public LocalDate getPhotoDeliveryBy() {
		return photoDeliveryBy;
	}

	public void setPhotoDeliveryBy(LocalDate photoDeliveryBy) {
		this.photoDeliveryBy = photoDeliveryBy;
	}

	public int getClosed() {
		return closed;
	}

	public void setClosed(int closed) {
		this.closed = closed;
	}

	public List<Photographer> getPhotographers() {
		return photographers;
	}

	public void setPhotographers(List<Photographer> photographers) {
		this.photographers = photographers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ContractMessage> getContractMessages() {
		return contractMessages;
	}

	public void setContractMessages(List<ContractMessage> contractMessages) {
		this.contractMessages = contractMessages;
	}

	@Override
	public int hashCode() {
		return Objects.hash(closed, contractMessages, description, eventEnd, eventStart, id, location, photoDeliveryBy,
				photographers, title, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contract other = (Contract) obj;
		return closed == other.closed && Objects.equals(contractMessages, other.contractMessages)
				&& Objects.equals(description, other.description) && Objects.equals(eventEnd, other.eventEnd)
				&& Objects.equals(eventStart, other.eventStart) && id == other.id
				&& Objects.equals(location, other.location) && Objects.equals(photoDeliveryBy, other.photoDeliveryBy)
				&& Objects.equals(photographers, other.photographers) && Objects.equals(title, other.title)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Contract [id=" + id + ", title=" + title + ", description=" + description + ", location=" + location
				+ ", eventStart=" + eventStart + ", eventEnd=" + eventEnd + ", photoDeliveryBy=" + photoDeliveryBy
				+ ", closed=" + closed + ", photographers=" + photographers + ", user=" + user + ", contractMessages="
				+ contractMessages + "]";
	}

}
