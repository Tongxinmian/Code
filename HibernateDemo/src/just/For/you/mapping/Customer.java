package just.For.you.mapping;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private Integer cid;
	private String cname;
	private String clevel;
	private String cphone;
	private Set<LinkMan> lmSet = new HashSet<LinkMan>();
	public Set<LinkMan> getLmSet() {
		return lmSet;
	}
	public void setLmSet(Set<LinkMan> lmSet) {
		this.lmSet = lmSet;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getClevel() {
		return clevel;
	}
	public void setClevel(String clevel) {
		this.clevel = clevel;
	}
	public String getCphone() {
		return cphone;
	}
	public void setCphone(String cphone) {
		this.cphone = cphone;
	}
}
