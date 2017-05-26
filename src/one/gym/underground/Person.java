package one.gym.underground;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Person {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key id;
	@Persistent
	private String name;
	@Persistent
	private String surName;
	@Persistent
	private String mail;
	@Persistent
	private String address;
	@Persistent
	private String birthday;
	@Persistent
	private boolean active;
	@Persistent
	private String kindOfPerson;
	
	
	
	public Person(String name, String surName, String mail, String address, String birthday, boolean active, String kindOfPerson) {
		super();
		this.name = name;
		this.surName = surName;
		this.mail = mail;
		this.address = address;
		this.birthday = birthday;
		this.active = active;
		this.kindOfPerson = kindOfPerson;
	}
	public Key getId() {
		return id;
	}
	public void setId(Key id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getKindOfPerson() {
		return kindOfPerson;
	}
	public void setKindOfPerson(String kindOfPerson) {
		this.kindOfPerson = kindOfPerson;
	}
	
	

}
