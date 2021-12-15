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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Photographer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "active")
	private int active;
	@Column(name = "business")
	private String business;
	@Column(name = "description")
	private String description;
	@Column(name = "buisness_logo_url")
	private String businessLogo;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "photographer")
	private List<Gallery> galleries;

	@ManyToMany(mappedBy = "photographers")
	private List<PhotoShootType> photoShootTypes;

	@ManyToMany(mappedBy = "photographers")
	private List<Contract> contracts;

	public Photographer() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBusinessLogo() {
		return businessLogo;
	}

	public void setBusinessLogo(String businessLogo) {
		this.businessLogo = businessLogo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Gallery> getGallery() {
		return galleries;
	}

	public void setGallery(List<Gallery> gallery) {
		this.galleries = gallery;
	}

	public List<PhotoShootType> getPhotoShootTypes() {
		return photoShootTypes;
	}

	public void setPhotoShootTypes(List<PhotoShootType> photoShootTypes) {
		this.photoShootTypes = photoShootTypes;
	}

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	public void addGallery(Gallery gallery) {
		if (galleries == null) {
			galleries = new ArrayList<>();
		}
		if (!galleries.contains(gallery)) {
			galleries.add(gallery);
			gallery.setPhotographer(this);
		}
	}

	public void removeGallery(Gallery gallery) {
		if (galleries != null && galleries.contains(gallery)) {
			galleries.remove(gallery);
			gallery.setPhotographer(this);
		}
	}
	
	public void addPhotoShootType(PhotoShootType photoShootType) {
		if (photoShootTypes == null) {
			photoShootTypes = new ArrayList<>();
		}
		if (!photoShootTypes.contains(photoShootType)) {
			photoShootTypes.add(photoShootType);
			photoShootType.addPhotographer(this);
		}
	}

	public void removePhotoShootType(PhotoShootType photoShootType) {
		if (photoShootTypes != null && photoShootTypes.contains(photoShootType)) {
			photoShootTypes.remove(photoShootType);
			photoShootType.removePhotographer(this);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(active, business, businessLogo, contracts, description, galleries, id, photoShootTypes,
				user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Photographer other = (Photographer) obj;
		return active == other.active && Objects.equals(business, other.business)
				&& Objects.equals(businessLogo, other.businessLogo) && Objects.equals(contracts, other.contracts)
				&& Objects.equals(description, other.description) && Objects.equals(galleries, other.galleries)
				&& id == other.id && Objects.equals(photoShootTypes, other.photoShootTypes)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Photographer [id=" + id + ", active=" + active + ", business=" + business + ", description="
				+ description + ", businessLogo=" + businessLogo + ", user=" + user + ", gallery=" + galleries
				+ ", photoShootTypes=" + photoShootTypes + ", contracts=" + contracts + "]";
	}

}
