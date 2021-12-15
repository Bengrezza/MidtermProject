package com.skilldistillery.photonerds.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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

	@OneToMany(mappedBy = "contracthasphotographer")
	private List<Payment> payments;

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

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public void addPayment(Payment payment) {
		if (payments == null) {
			payments = new ArrayList<>();
		}
		if (!payments.contains(payment)) {
			payments.add(payment);
			payment.setContracthasphotographer(this);
		}
	}

	public void removePayment(Payment payment) {
		if (payment != null && payments.contains(payment)) {
			payments.remove(payment);
			payment.setContracthasphotographer(this);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(comment, id, payments, price, rating);
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
				&& Objects.equals(payments, other.payments)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && rating == other.rating;
	}

	@Override
	public String toString() {
		return "ContractHasPhotographer [id=" + id + ", rating=" + rating + ", comment=" + comment + ", price=" + price
				+ ", payments=" + payments + "]";
	}

}
