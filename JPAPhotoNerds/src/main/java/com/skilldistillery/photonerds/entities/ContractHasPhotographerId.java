package com.skilldistillery.photonerds.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ContractHasPhotographerId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "contract_id")
	private int contractId;
	@Column(name = "photographer_id")
	private int photographerId;
	
	public ContractHasPhotographerId() {
		
	}

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public int getPhotographerId() {
		return photographerId;
	}

	public void setPhotographerId(int photographerId) {
		this.photographerId = photographerId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contractId, photographerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContractHasPhotographerId other = (ContractHasPhotographerId) obj;
		return contractId == other.contractId && photographerId == other.photographerId;
	}

//	@Override
//	public String toString() {
//		return "ContractHasPhotographerId [contractId=" + contractId + ", photographerId=" + photographerId + "]";
//	}

}
