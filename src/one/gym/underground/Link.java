package one.gym.underground;

import java.io.Serializable;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Link implements Serializable{
	
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key id;
	@Persistent
	private String name;
	@Persistent
	private String kind;
	@Persistent
	private boolean canI = false;
	@Persistent
	private boolean C = false;
	@Persistent
	private boolean R = false;
	@Persistent
	private boolean U = false;
	@Persistent
	private boolean D = false;
	
	public Link(String name,String kind, boolean c, boolean r, boolean u, boolean d) {
		super();
		this.name = name;
		this.kind = kind;
		C = c;
		R = r;
		U = u;
		D = d;
		canI = true;
	}
	
	public Link(String name, String kind){
		this.name = name;
		this.kind = kind;
	}
	
	public Link(String name, String kind, boolean canI) {
		this.name = name;
		this.kind = kind;
		this.canI = canI;
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

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public boolean isCanI() {
		return canI;
	}

	public void setCanI(boolean canI) {
		this.canI = canI;
	}

}
