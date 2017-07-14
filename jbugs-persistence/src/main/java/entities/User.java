package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name = "USER")
//@Access(AccessType.PROPERTY)
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_User")
	private int idUser;
	
	@Column(name = "First_Name", length = 50, nullable = false)
	private String firstName;
	
	@Column(name = "Last_Name", length = 50,  nullable = false)
	private String lastName;
	
	@Column(name = "Phone_Number", length = 20)
	private String phoneNumber;
	
	@Column(name = "Email", length = 50,  nullable = false, unique = true)
	private String email;
	
	@Column(name = "Username", length = 15,  nullable = false, unique = true)
	private String username;
	
	@Column(name = "Password", length = 32,  nullable = false)
	private String password;
	
	@Column(name = "Status",  nullable = false)
	private boolean active;
	
	@ManyToMany
	@JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "iduser", referencedColumnName = "ID_User"),
			   inverseJoinColumns = @JoinColumn(name = "idrole", referencedColumnName = "ID_Role"))
	private List<Role> roles;
	
	public User(){
		
	}

	public User(String firstName, String lastName, String phoneNumber, String email, String username, String password,
			boolean status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.username = username;
		this.password = password;
		this.active = status;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean status) {
		this.active = status;
	}
	
	
	
}
	