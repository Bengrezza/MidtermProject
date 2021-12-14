package com.skilldistillery.photonerds.entities;

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
	@JoinTable(name = "image_has_gallery", joinColumns = @JoinColumn(name = "gallery_id"), inverseJoinColumns = @JoinColumn(name = "image_id"))
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

	public List<Gallery> getGalleries() {
		return galleries;
	}

	public void setGalleries(List<Gallery> galleries) {
		this.galleries = galleries;
	}

	@Override
	public int hashCode() {
		return Objects.hash(galleries, id, title, uploadDate, urlLink);
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
		return Objects.equals(galleries, other.galleries) && id == other.id && Objects.equals(title, other.title)
				&& Objects.equals(uploadDate, other.uploadDate) && Objects.equals(urlLink, other.urlLink);
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", urlLink=" + urlLink + ", uploadDate=" + uploadDate + ", title=" + title
				+ ", galleries=" + galleries + "]";
	}

}
