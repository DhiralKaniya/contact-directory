package Contact_Dictionary;

public class Contact {
	private String Group;
	private String Address;
	private String Mobile;
	private String Email;
	Contact(){
		Group = null;
		Address = null;
		Mobile = null;
		Email = null;
	}
	Contact(String Group,String Address,String Mobile,String Email){
		this.Group = Group;
		this.Address = Address;
		this.Mobile = Mobile;
		this.Email = Email;
	}
	public void setGroup(String group){
		this.Group = group;
	}
	public String getGroup(){
		return this.Group;
	}
	public void setAddress(String Address){
		this.Address = Address;
	}
	public String getAddress(){
		return this.Address;
	}
	public void setMobile(String Mobile){
		this.Mobile = Mobile;
	}
	public String getMobile(){
		return this.Mobile;
	}
	public void setEmail(String Email){
		this.Email = Email;
	}
	public String getEmail(){
		return this.Email;
	}
	/*public void setPersonName(String personName){
		this.personName = personName;
	}*/
}
