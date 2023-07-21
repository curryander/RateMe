package app.model;

import java.io.Serializable;

import jakarta.persistence.*;


/**
 * The persistent class for the rateme_user database table.
 * 
 */
@Entity
@Table(name = "rateme_user")
@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "SELECT r FROM User r"),
	@NamedQuery(name = "User.findByUserName", query = "SELECT r FROM User r WHERE r.username = :username")
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false)
	private Integer userId;

	@Column(name = "username", length = 20, nullable = false, unique = true)
	private String username;

	@Column(name = "E_Mail", length = 50, nullable = false)
	private String email;

	@Column(name = "firstname", length = 20, nullable = false)
	private String firstname;

	@Column(name = "lastname", length = 20, nullable = false)
	private String lastname;

	@Column(length = 30, nullable = false)
	private String street;

	@Column(length = 20, nullable = false)
	private String streetNr;

	@Column(length = 30, nullable = false)
	private String city;

	@Column(length = 20, nullable = false)
	private String zip;

	@Column(name = "password_hash", nullable = false)
	private byte[] passwordHash;

	@Column(name = "password_salt", nullable = false)
	private byte[] passwordSalt;

	public User() {
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNr() {
		return streetNr;
	}

	public void setStreetNr(String streetNr) {
		this.streetNr = streetNr;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public byte[] getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(byte[] passwordHash) {
		this.passwordHash = passwordHash;
	}

	public byte[] getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(byte[] passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
}