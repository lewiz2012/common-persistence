package com.lewiz.common.persistence.entity;


import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.JoinColumnOrFormula;


@Entity
@Table(name="USER")
public class User extends GenericEntity<User> implements Serializable {
	@Transient
	private static final long serialVersionUID = -7642375430811248950L;
	
	private String loginName;
	
	@OneToMany(mappedBy="referenceId")
//	@JoinColumn(name="REFERENCE_ID")
	private Collection<Contact> contacts = new LinkedHashSet<Contact>();

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Collection<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Collection<Contact> contacts) {
		this.contacts = contacts;
	}
	
//	@ManyToOne
//    @JoinColumnOrFormula(formula="('USER')")
//    public String getIdType() {
//        return "USER";
//    }

	@Override
	User getEntity() {
		return this;
	}

	@Override
	User newInstance() {
		return new User();
	}
}
