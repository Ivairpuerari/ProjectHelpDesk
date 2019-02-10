package com.ivairpuerari.helpDesk.domain.enums;

public enum Status {
	NEW,
	ASSIGNED,
	RESOLVED,
	APPROVED,
	DISAPPROVED,
	CLOSED;
	
	public static Status getStatus(String status) {
		switch(status) {
			case "NEW" : return NEW;
			case "RESOLVED" : return RESOLVED;
			case "APPROVED" : return APPROVED;
			case "DISAPPROVED" : return DISAPPROVED;
			case "ASSIGNED" : return ASSIGNED;
			case "CLOSED" : return CLOSED;
			default : return NEW;
		}
	}
}
