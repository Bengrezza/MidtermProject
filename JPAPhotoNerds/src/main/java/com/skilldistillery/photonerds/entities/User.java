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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "enabled")
	private int enabled;
	@Column(name = "role")
	private String role;
	@Column(name = "email")
	private String email;
	@Column(name = "join_date")
	private LocalDateTime joinDate;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;

	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@OneToOne(mappedBy = "user")
	private Photographer photographer;

	@OneToMany(mappedBy = "user")
	private List<Contract> contracts;

	@OneToMany(mappedBy = "user")
	private List<ContractMessage> contractMessages;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Photographer getPhotographer() {
		return photographer;
	}

	public void setPhotographer(Photographer photographer) {
		this.photographer = photographer;
	}

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	public List<ContractMessage> getContractMessages() {
		return contractMessages;
	}

	public void setContractMessages(List<ContractMessage> contractMessages) {
		this.contractMessages = contractMessages;
	}

	public void addContract(Contract contract) {
		if (contracts == null) {
			contracts = new ArrayList<>();
		}
		if (!contracts.contains(contract)) {
			contracts.add(contract);
			contract.setUser(this);
		}
	}

	public void addContractMessage(ContractMessage contractMessage) {
		if (contractMessages == null) {
			contractMessages = new ArrayList<>();
		}
		if (!contractMessages.contains(contractMessage)) {
			contractMessages.add(contractMessage);
			contractMessage.setUser(this);
		}
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
		User other = (User) obj;
		return Objects.equals(address, other.address) && Objects.equals(contractMessages, other.contractMessages)
				&& Objects.equals(contracts, other.contracts) && Objects.equals(email, other.email)
				&& enabled == other.enabled && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(joinDate, other.joinDate) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password) && Objects.equals(photographer, other.photographer)
				&& Objects.equals(role, other.role) && Objects.equals(username, other.username);
	}

//	@Override
//	public String toString() {
//		return "User [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
//				+ ", role=" + role + ", email=" + email + ", joinDate=" + joinDate + ", firstName=" + firstName
//				+ ", lastName=" + lastName + ", address=" + address + ", contracts="
//				+ contracts + ", contractMessages=" + contractMessages + "]";
//	}

}