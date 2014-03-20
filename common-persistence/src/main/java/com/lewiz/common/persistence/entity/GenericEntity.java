package com.lewiz.common.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class GenericEntity<T> extends BaseEntity<T> implements Serializable {
	@Transient
	private static final long serialVersionUID = -7357922312658194142L;

	private Date effectiveDate;
	private Date inactiveDate;
	
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public Date getInactiveDate() {
		return inactiveDate;
	}
	public void setInactiveDate(Date inactiveDate) {
		this.inactiveDate = inactiveDate;
	}
	
}
