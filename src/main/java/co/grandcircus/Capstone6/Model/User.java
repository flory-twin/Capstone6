package co.grandcircus.Capstone6.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String email;
	// TODO Suspect there's a better way to do this...
	private String password;
	
	@OneToMany(mappedBy="creator")
	private List<Task> tasks;
	
	
	
	public User() {
		super();
	}
	
	public User(String email, String password, List<Task> tasks) {
		this();
		this.email = email;
		this.password = password;
		this.tasks = tasks;
	}
	
	public User(Integer id, String email, String password, List<Task> tasks) {
		this(email, password, tasks);
		this.id = id;
	}

	
	
	
	
	public List<Task> getTasks() {
		return tasks;
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

	public Integer getId() {
		return id;
	}
}
