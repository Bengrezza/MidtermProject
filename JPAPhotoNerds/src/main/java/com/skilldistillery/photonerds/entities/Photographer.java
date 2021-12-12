package com.skilldistillery.photonerds.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	@Column(name= "buisness_logo_url")
	private String businessLogo;
	
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

	@Override
	public int hashCode() {
		return Objects.hash(active, business, businessLogo, description, id);
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
				&& Objects.equals(businessLogo, other.businessLogo) && Objects.equals(description, other.description)
				&& id == other.id;
	}

	@Override
	public String toString() {
		return "Photographer [id=" + id + ", active=" + active + ", business=" + business + ", description="
				+ description + ", businessLogo=" + businessLogo + "]";
	}
	
	

}
