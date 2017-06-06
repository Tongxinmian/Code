package just.For.you.mapping;

import java.util.HashSet;
import java.util.Set;

public class User {
	private Integer uid;
	private String uname;
	private String password;
	
	private Set<Role> setRole = new HashSet<Role>();
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Role> getSetRole() {
		return setRole;
	}
	public void setSetRole(Set<Role> setRole) {
		this.setRole = setRole;
	}
	
}
