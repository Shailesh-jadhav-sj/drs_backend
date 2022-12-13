package com.example.drs.entity;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class POC {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pocId;
	private String pocName;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name="did",referencedColumnName = "did")
	private ResourceHub resourceHub;

	private String startDate;
	private String endDate;
	
	private String password;
	
	public POC(long pocId, String pocName, ResourceHub resourceHub, String startDate, String endDate) {
		super();
		this.pocId = pocId;
		this.pocName = pocName;
		this.resourceHub = resourceHub;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public POC(long pocId, String pocName, ResourceHub resourceHub) {
		super();
		this.pocId = pocId;
		this.pocName = pocName;
		this.resourceHub = resourceHub;
	}

	public POC() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getPocId() {
		return pocId;
	}

	public void setPocId(long pocId) {
		this.pocId = pocId;
	}

	public String getPocName() {
		return pocName;
	}

	public void setPocName(String pocName) {
		this.pocName = pocName;
	}

	public ResourceHub getResource() {
		return resourceHub;
	}

	public void setResource(ResourceHub resourceHub) {
		this.resourceHub = resourceHub;
	}

	@Override
	public String toString() {
		return "POC [pocId=" + pocId + ", pocName=" + pocName + ", resource=" + resourceHub + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
