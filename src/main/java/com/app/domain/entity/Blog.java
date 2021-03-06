package com.app.domain.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Blog {

	@Id
	@GeneratedValue
	private int id;
	private String url;
	private String name;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="blog")
	private List<Item> item;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
