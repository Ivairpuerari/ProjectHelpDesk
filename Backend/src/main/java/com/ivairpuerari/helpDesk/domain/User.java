package com.ivairpuerari.helpDesk.domain;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ivairpuerari.helpDesk.domain.enums.Profile;

@Document
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Indexed(unique = true)
	@NotBlank(message = "Email required")
	@Email(message = "Email invalid")
	private String email;

	@NotBlank(message = "Password required")
	@Size(min = 6)
	private String password;
	private Profile profile;

	public User() {
	}

	public User(String id, @NotBlank(message = "Email required") @Email(message = "Email invalid") String email,
			@NotBlank(message = "Password required") @Size(min = 6) String password, Profile profile) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.profile = profile;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
