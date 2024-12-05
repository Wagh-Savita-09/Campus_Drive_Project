package com.jbk.Enum;

public enum ApplicationStatus {

	    APPLIED("Submitted"),
	    APPROVED("Approved"),
	    REJECTED("Rejected");

	    private final String value;

	    ApplicationStatus(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}
