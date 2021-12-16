package com.skilldistillery.photonerds.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "street")
	private String street;
	@Column(name = "street2")
	private String street2;
	@Column(name = "state_province")
	private String state;
	private String city;
	@Column(name = "postal_code")
	private int postalCode;
	private String phone;

	@OneToOne(mappedBy = "address")
	private User user;

	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

	public Address() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

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
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && id == other.id && Objects.equals(phone, other.phone)
				&& postalCode == other.postalCode && Objects.equals(state, other.state)
				&& Objects.equals(street, other.street) && Objects.equals(street2, other.street2);
	}

//	@Override
//	public String toString() {
//		return "Address [street=" + street + ", street2=" + street2 + ", state=" + state + ", city=" + city
//				+ ", postalCode=" + postalCode + ", phone=" + phone + "]";
//	}

}
