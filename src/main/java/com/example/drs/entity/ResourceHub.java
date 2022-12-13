package com.example.drs.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class ResourceHub {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long did;
	
	private String dname;
	
	@OneToMany(mappedBy = "did")
	private List<Resources> resource;

	public ResourceHub() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResourceHub(long did, String dname) {
		super();
		this.did = did;
		this.dname = dname;
	}

	public long getDid() {
		return did;
	}

	public void setDid(long did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "ResourceHub [did=" + did + ", dname=" + dname + "]";
	}
	
	
}
