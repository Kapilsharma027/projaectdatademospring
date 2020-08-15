package pacakge.project.author;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pacakge.project.util.AppConstant.Result;




//annotation used to declare it is a entity 
@Entity
@Table(name = "tblauthor")
public class Author {
//Id is used to define which key is primary.
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "dob")
	@Temporal(TemporalType.TIME)
	private Date DOB;
	@Column(name = "mobile")
	private Long mobile;
	
	@Column(name = "result")
	@Enumerated(EnumType.STRING)
	private Result result;
	

	public Author(Integer id, String firstName, String lastName, Date dOB, Long mobile, Result result) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		DOB = dOB;
		this.mobile = mobile;
		this.result = result;
	}
	public Author() {
		super();
		
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

}
