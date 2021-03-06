package com.skilldistillery.photonerds.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Gallery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "photographer_id")
	private Photographer photographer;

	@ManyToMany(mappedBy = "galleries")
	private List<Image> images;

	public Gallery() {

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

	public Photographer getPhotographer() {
		return photographer;
	}

	public void setPhotographer(Photographer photographer) {
		this.photographer = photographer;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public void addImage(Image image) {
		if (images == null) {
			images = new ArrayList<>();
		}
		if (!images.contains(image)) {
			images.add(image);
			image.addGallery(this);
		}
	}

	public void removeImage(Image image) {
		if (images != null && images.contains(image)) {
			images.remove(image);
			image.removeGallery(this);
		}
	}

//	@Override
//	public String toString() {
//		return "Gallery [id=" + id + ", title=" + title + ", description=" + description + ", photographer="
//				+ photographer + ", images=" + images + "]";
//	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gallery other = (Gallery) obj;
		return id == other.id;
	}

}
