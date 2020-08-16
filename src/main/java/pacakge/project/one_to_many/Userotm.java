package pacakge.project.one_to_many;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users_otm")
public class Userotm implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "userid")
    private Long userId;


	private String name;
    private String email;
    private String password;

    
    @OneToMany(mappedBy = "userotm", cascade = CascadeType.ALL, orphanRemoval=true)
    private Set<Addressotm> addressotm = new HashSet<Addressotm>();

  
    public Userotm() {
		super();
	}
    
	public Userotm(String name, String email, String password, Set<Addressotm> addressotm) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.addressotm = addressotm;
	}

    public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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