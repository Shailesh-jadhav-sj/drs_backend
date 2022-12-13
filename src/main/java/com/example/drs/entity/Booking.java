package com.example.drs.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bid;
	private Integer status;
	private String Date;
	private Integer starttime;
	private Integer endtime;
	@ManyToOne
	private Resources Rid;
	@ManyToOne
	private User Uid;
	@Override
	public String toString() {
		return "Booking [bid=" + bid + ", status=" + status + ", Date=" + Date + ", starttime=" + starttime
				+ ", endtime=" + endtime + ", Rid=" + Rid + ", Uid=" + Uid + "]";
	}
	public long getBid() {
		return bid;
	}
	public void setBid(long bid) {
		this.bid = bid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public Integer getStarttime() {
		return starttime;
	}
	public void setStarttime(Integer starttime) {
		this.starttime = starttime;
	}
	public Integer getEndtime() {
		return endtime;
	}
	public void setEndtime(Integer endtime) {
		this.endtime = endtime;
	}
	public Resources getRid() {
		return Rid;
	}
	public void setRid(Resources rid) {
		Rid = rid;
	}
	public User getUid() {
		return Uid;
	}
	public void setUid(User uid) {
		Uid = uid;
	}
	public Booking(long bid, Integer status, String date, Integer starttime, Integer endtime, Resources rid, User uid) {
		super();
		this.bid = bid;
		this.status = status;
		Date = date;
		this.starttime = starttime;
		this.endtime = endtime;
		Rid = rid;
		Uid = uid;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
