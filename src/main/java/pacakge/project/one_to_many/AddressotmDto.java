package pacakge.project.one_to_many;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class AddressotmDto implements Serializable {
	
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    @JsonIgnore
	private UserotmDto userotmDto;
	
	public AddressotmDto() {
		super();
	}
	public AddressotmDto(String street, String city, String state, String zipCode, String country, UserotmDto userotmDto) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
		this.userotmDto = userotmDto;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public UserotmDto getUserotmDto() {
		return userotmDto;
	}
	public void setUserotmDto(UserotmDto userotmDto) {
		this.userotmDto = userotmDto;
	}
   


}
