package just.For.you.mapping;


public class LinkMan {
	private Integer link_id;
	private String link_name;
	private String link_phone;
	private String link_gender;
	private Customer customer;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Integer getLink_id() {
		return link_id;
	}
	public void setLink_id(Integer link_id) {
		this.link_id = link_id;
	}
	public String getLink_name() {
		return link_name;
	}
	public void setLink_name(String link_name) {
		this.link_name = link_name;
	}
	public String getLink_phone() {
		return link_phone;
	}
	public void setLink_phone(String link_phone) {
		this.link_phone = link_phone;
	}
	public String getLink_gender() {
		return link_gender;
	}
	public void setLink_gender(String link_gender) {
		this.link_gender = link_gender;
	}
}
