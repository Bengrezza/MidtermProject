package com.skilldistillery.photonerds.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contract_has_photographer")
public class ContractHasPhotographer {

	@EmbeddedId
	private ContractHasPhotographerId id;

	@Column(name = "rating")
	private int rating;
	@Column(name = "comment")
	private String comment;
	@Column(name = "price")
	private double price;

	public ContractHasPhotographer() {

	}

	public ContractHasPhotographerId getId() {
		return id;
	}

	public void setId(ContractHasPhotographerId id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comment, id, price, rating);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContractHasPhotographer other = (ContractHasPhotographer) obj;
		return Objects.equals(comment, other.comment) && Objects.equals(id, other.id)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && rating == other.rating;
	}

	@Override
	public String toString() {
		return "ContractHasPhotographer [id=" + id + ", rating=" + rating + ", comment=" + comment + ", price=" + price
				+ "]";
	}

}
