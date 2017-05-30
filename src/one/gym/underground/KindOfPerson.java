package one.gym.underground;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class KindOfPerson {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key id;
	@Persistent
	private String name;
	@Persistent
	private String description;
	@Persistent
	private List<Link> permision = new ArrayList<Link>();

	public KindOfPerson(String name, String description) {
		super();
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Link> getPermision() {
		return permision;
	}

	public void setPermision(List<Link> permision) {
		this.permision = permision;
	}

}
