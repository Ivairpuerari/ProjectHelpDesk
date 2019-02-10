package com.ivairpuerari.helpDesk.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.ivairpuerari.helpDesk.domain.enums.Status;


public class ChangeStatus implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@DBRef
	private Ticket ticket;

	@DBRef
	private User userChange;

	private Date dateChangeStatus;
	private Status status;

	public ChangeStatus() {
	}

	public ChangeStatus(String id, Ticket ticket, User userChange, Date dateChangeStatus, Status status) {
		super();
		this.id = id;
		this.ticket = ticket;
		this.userChange = userChange;
		this.dateChangeStatus = dateChangeStatus;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public User getUserChange() {
		return userChange;
	}

	public void setUserChange(User userChange) {
		this.userChange = userChange;
	}

	public Date getDateChangeStatus() {
		return dateChangeStatus;
	}

	public void setDateChangeStatus(Date dateChangeStatus) {
		this.dateChangeStatus = dateChangeStatus;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChangeStatus other = (ChangeStatus) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
