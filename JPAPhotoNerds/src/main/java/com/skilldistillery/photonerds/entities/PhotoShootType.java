package com.skilldistillery.photonerds.entities;

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
import javax.persistence.Table;

@Entity
@Table(name = "photo_shoot_type")
public class PhotoShootType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;

	@ManyToMany
	@JoinTable(name = "photo_shoot_style_has_photographer", joinColumns = @JoinColumn(name = "photographer_id"), inverseJoinColumns = @JoinColumn(name = "photo_shoot_type_id"))
	private List<Photographer> photographers;

	public PhotoShootType() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Photographer> getPhotographers() {
		return photographers;
	}

	public void setPhotographers(List<Photographer> photographers) {
		this.photographers = photographers;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, photographers);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhotoShootType other = (PhotoShootType) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(photographers, other.photographers);
	}

	@Override
	public String toString() {
		return "PhotoShootType [id=" + id + ", name=" + name + ", photographers=" + photographers + "]";
	}

}
