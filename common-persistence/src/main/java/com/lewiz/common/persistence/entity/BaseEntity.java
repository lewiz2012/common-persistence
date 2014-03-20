package com.lewiz.common.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class BaseEntity<T> implements Serializable {
	@Transient
	private static final long serialVersionUID = -2773080425475030528L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private long clientId;
	
	private Date createDate;
	private Date changeDate;
	
	abstract T newInstance();
	abstract T getEntity();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	
	@SuppressWarnings("rawtypes")
	protected String getEntityTableName(Class clazz) {
		String tableName = clazz.getSimpleName().toUpperCase();
		
		return tableName;
	}
	
	public String getEntityTableName() {
		return getEntityTableName(getEntity().getClass());
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
}
