package com.skilldistillery.photonerds.entities;

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
	private List<Gallery> gallery;

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
		return gallery;
	}

	public void setGallery(List<Gallery> gallery) {
		this.gallery = gallery;
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

	@Override
	public int hashCode() {
		return Objects.hash(active, business, businessLogo, contracts, description, gallery, id, photoShootTypes, user);
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
				&& Objects.equals(description, other.description) && Objects.equals(gallery, other.gallery)
				&& id == other.id && Objects.equals(photoShootTypes, other.photoShootTypes)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Photographer [id=" + id + ", active=" + active + ", business=" + business + ", description="
				+ description + ", businessLogo=" + businessLogo + ", user=" + user + ", gallery=" + gallery
				+ ", photoShootTypes=" + photoShootTypes + ", contracts=" + contracts + "]";
	}

}
