package com.skilldistillery.photonerds.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	@Override
	public int hashCode() {
		return Objects.hash(closed, description, eventEnd, eventStart, id, location, photoDeliveryBy, title);
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
		return closed == other.closed && Objects.equals(description, other.description)
				&& Objects.equals(eventEnd, other.eventEnd) && Objects.equals(eventStart, other.eventStart)
				&& id == other.id && Objects.equals(location, other.location)
				&& Objects.equals(photoDeliveryBy, other.photoDeliveryBy) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Contract [id=" + id + ", title=" + title + ", description=" + description + ", location=" + location
				+ ", eventStart=" + eventStart + ", eventEnd=" + eventEnd + ", photoDeliveryBy=" + photoDeliveryBy
				+ ", closed=" + closed + "]";
	}

}
