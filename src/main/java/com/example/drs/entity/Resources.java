package com.example.drs.entity;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;





@Entity
public class Resources {

	@jakarta.persistence.Id
	private long Id;
	
	private String Name;
	private String Specification;
	private String Value;
	private Integer Dtime;
	@ManyToOne
	private ResourceHub did;
	
	@OneToMany(mappedBy = "Rid")
	List<Booking> Bookings;
	public Resources(long id, String name, String specification, String value, Integer dtime) {
		super();
		Id = id;
		Name = name;
		Specification = specification;
		Value = value;
		Dtime = dtime;
	}

	public Resources() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSpecification() {
		return Specification;
	}

	public void setSpecification(String specification) {
		Specification = specification;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}

	public Integer getDtime() {
		return Dtime;
	}

	public void setDtime(Integer dtime) {
		Dtime = dtime;
	}

	public ResourceHub getDid() {
		return did;
	}

	public void setDid(ResourceHub did) {
		this.did = did;
	}

	
	
}
