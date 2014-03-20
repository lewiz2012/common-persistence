package com.lewiz.common.persistence.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

/**
 * client or user contact
 */
@Entity
public class Contact extends GenericEntity<Contact> implements Serializable {
	@Transient
	private static final long serialVersionUID = -1386991723624288958L;

//	@ManyToOne
	@PrimaryKeyJoinColumn
//	@Column(name="REFERENCE_ID")
	@JoinColumn(nullable = false)
	private Long referenceId;
	
	private String idType;

	private String phone;

	private String address;

	public void setReference(GenericEntity<?> referenceEntity) {
		if (referenceEntity == null ) {
			throw new RuntimeException("provide a null reference Object to 'Contact' entity");
		}
		else if (referenceEntity.getId() == null) {
			throw new RuntimeException("provide a null reference ID to 'Contact' entity");
		}
		else if (referenceEntity.getId() <= 0) {
			throw new RuntimeException("provide an invalid reference ID[" + referenceEntity.getId() + "] to 'Contact' entity");
		}
		
		this.setReferenceId (referenceEntity.getId());
		this.setClientId(referenceEntity.getClientId());
		this.setIdType(referenceEntity.getEntityTableName().toUpperCase());
	}
	
	public Long getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(Long referenceId) {
		this.referenceId = referenceId;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	Contact getEntity() {
		return this;
	}
	
	@Override
	Contact newInstance() {
		return new Contact();
	}

}
