package pacakge.project.one_to_many;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


public class UserotmDto implements Serializable {



	private String name;
    private String email;
    private String password;
  
    private Set<Addressotm> addressotm;

  
    public UserotmDto() {
		super();
	}
    
	public UserotmDto(String name, String email, String password, Set<Addressotm> addressotm) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.addressotm = addressotm;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Addressotm> getAddressotm() {
		return addressotm;
	}
	public void setAddressotm(Set<Addressotm> addressotm) {
		this.addressotm = addressotm;
	}



    // getters and setters, equals(), toString() .... (omitted for brevity)
}