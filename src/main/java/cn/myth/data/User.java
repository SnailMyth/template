package cn.myth.data;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name = "user")
public class User implements Serializable {
	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GenericGenerator(name = "generator", strategy = "native")
	@GeneratedValue(generator="generator")
	private int id;
	@Column(name = "username", nullable = false, unique = true, length = 32)
	private String username;
	@Column(name = "passwd", nullable = false, unique = false, length = 32)
	private String passwd;
	@Column(name = "active", nullable = false, unique = false)
	private boolean active = false;
	
	
	public User() {
	}
	
	public User(String id) {
		this.id = Integer.parseInt(id);
	}
	

	public User(int id, String username, String passwd, boolean active) {
		this.id = id;
		this.username = username;
		this.passwd = passwd;
		this.active = active;
	}


	public User(String username, String passwd) {
		this.username = username;
		this.passwd = passwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public User(int id, String username, String passwd) {
		super();
		this.id = id;
		this.username = username;
		this.passwd = passwd;
	}
	
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


	public void active() {
		this.setActive(true);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", passwd=" + passwd + ", active=" + active + "]";
	}
	
}
