package com.skilldistillery.photonerds.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

@Entity
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "url_link")
	private String urlLink;
	@Column(name = "upload_date")
	private LocalDateTime uploadDate;
	@Column(name = "title")
	private String title;

	@ManyToMany
	@JoinTable(name = "image_has_gallery", joinColumns = @JoinColumn(name = "image_id"), inverseJoinColumns = @JoinColumn(name = "gallery_id"))
	private List<Gallery> galleries;

	public Image() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrlLink() {
		return urlLink;
	}

	public void setUrlLink(String urlLink) {
		this.urlLink = urlLink;
	}

	public LocalDateTime getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(LocalDateTime uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Gallery> getGallery() {
		return galleries;
	}

	public void setGallery(List<Gallery> gallery) {
		this.galleries = gallery;
	}

	public void addGallery(Gallery gallery) {
		if (galleries == null) {
			galleries = new ArrayList<>();
		}
		if (!galleries.contains(gallery)) {
			galleries.add(gallery);
			gallery.addImage(this);
		}
	}

	public void removeGallery(Gallery gallery) {
		if (galleries != null && galleries.contains(gallery)) {
			galleries.remove(gallery);
			gallery.removeImage(this);
		}
	}

//	@Override
//	public String toString() {
//		return "Image [id=" + id + ", urlLink=" + urlLink + ", uploadDate=" + uploadDate + ", title=" + title
//				+ ", gallery=" + galleries + "]";
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
		Image other = (Image) obj;
		return id == other.id;
	}

}
