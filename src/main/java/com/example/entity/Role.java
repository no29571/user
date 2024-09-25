package com.example.entity;

public enum Role {
	GUEST("Guest"),
	USER("User"),
	ADMIN("Admin");
	
	private final String displayName;
	
	Role(String displayName) {
		this.displayName = displayName;
	}
		
	public String getDisplayName() {
		return displayName;
	}
	
	public String getAuthName() {
		return "ROLE_" + name();
	}
}
