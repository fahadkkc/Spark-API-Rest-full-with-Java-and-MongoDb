package model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class User {
	
	@Id
	private ObjectId id;
	private String name;
	private Float expense;
	private String email;
	private String number;
	
	public User(){
		
	}
	
	public User(String name, Float price, String email, String number) {
		super();
		this.name = name;
		this.email = email;
		this.expense = price;
		this.number = number;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getExpense() {
		return expense;
	}

	public void setExpense(Float price) {
		this.expense = price;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
