package xyz.casualcookie.ponyslayer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Application User Class
 * @author mpinto
 */
@Entity
@Table(name="USER")
public class User extends DomainObjectEntity{
	private static final long serialVersionUID = 1L;

	@Column(name="display_name")
	String displayName;
	
	@Column(name="login_name")
	String loginName;
	
	@Column(name="password")
	String password;
	
	@Column(name="admin")
	boolean admin;
	
	// Getters and Setters
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
