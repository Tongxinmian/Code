package just.For.you.mapping;

import java.util.HashSet;
import java.util.Set;

public class Role {
	private Integer rid;
	private String rname;
	private String rmemo;
	private Set<User> setUser = new HashSet<User>();
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRmemo() {
		return rmemo;
	}
	public void setRmemo(String rmemo) {
		this.rmemo = rmemo;
	}
	public Set<User> getSetUser() {
		return setUser;
	}
	public void setSetUser(Set<User> setUser) {
		this.setUser = setUser;
	}
}
