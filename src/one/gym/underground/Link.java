package one.gym.underground;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Link {
	
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key id;
	@Persistent
	private String name;
	@Persistent
	private boolean C = false;
	@Persistent
	private boolean R = false;
	@Persistent
	private boolean U = false;
	@Persistent
	private boolean D = false;
	
	public Link(String name, boolean c, boolean r, boolean u, boolean d) {
		super();
		this.name = name;
		C = c;
		R = r;
		U = u;
		D = d;
	}
	
	public Link(String name){
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
	public boolean isC() {
		return C;
	}
	public void setC(boolean c) {
		C = c;
	}
	public boolean isR() {
		return R;
	}
	public void setR(boolean r) {
		R = r;
	}
	public boolean isU() {
		return U;
	}
	public void setU(boolean u) {
		U = u;
	}
	public boolean isD() {
		return D;
	}
	public void setD(boolean d) {
		D = d;
	}

}
