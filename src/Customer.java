
public class Customer {
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private String phone;
    private String email;
    private String userName;
	private String passWord;
	
	
    public Customer(String id, String firstname, String lastname, String address, String gender, String phone, String email, String userName, String passWord) {
        this.id = id;
        this.firstName = firstname;
        this.lastName= lastname;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.userName=userName;
		this.passWord=passWord;
    }
    //getter method that will return customer ID
    //no setter method for id as it will be automatically generated and cannot be change
	public String getId() {
        return id;
    }
	//getter method that will return customer first name
    public String getFirstName() {
		return firstName;
	}
    //setter method to enable update details
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	//getter method for last name
	public String getLastName() {
		return lastName;
	}
	//setter method to enable update details
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	//getter method for address
	public String getAddress() {
        return address;
    }
	//setter method to enable update details
    public void setAddress(String address) {
        this.address = address;
    }
    //getter method for last name
    public String getGender() {
        return gender;
    }
    //setter method to enable update details
    public void setGender(String gender) {
        this.gender = gender;
    }
    //getter method for phone number
    public String getPhone() {
        return phone;
    }
    //setter method to enable update details
    public void setPhone(String phone) {
        this.phone = phone;
    }
    //getter method for email
    public String getEmail() {
        return email;
    }
    //setter method to enable update details
    public void setEmail(String email) {
        this.email = email;
    }
    //username is automatically generated thats why theres no setter method.
	public String getUserName() {
		return userName;
	}
	//getter method for password
	public String getPassWord() {
		return passWord;
	}
	//setter method for password
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
    
}
