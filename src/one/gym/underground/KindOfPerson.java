package one.gym.underground;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

import java.util.HashMap;

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
	private HashMap<Key, Boolean> resources = new HashMap<Key, Boolean>();
	
	public KindOfPerson(String name) {
		super();
		this.name = name;
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
	public HashMap<Key, Boolean> getResources() {
		return resources;
	}
	public void setResources(HashMap<Key, Boolean> resources) {
		this.resources = resources;
	}
	
	
	
}
