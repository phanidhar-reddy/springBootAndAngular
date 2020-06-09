package com.rest.scloud.springCloud.model;

import java.util.Date;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class Todo {
	
    private Long id ; 
	
	private String name ; 
    
    private String todos ; 
    
    private boolean isDone  ; 
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTodos() {
		return todos;
	}
	public void setTodos(String todos) {
		this.todos = todos;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	private Date targetDate  ;
	
	public Todo(String name, String todos, boolean isDone, Date targetDate) {
	
		this.id = id;
		this.name = name;
		this.todos = todos;
		this.isDone = isDone;
		this.targetDate = targetDate;
	}
	public Todo() {
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


    @Override
	public String toString() {
		return "Todo [id=" + id + ", name=" + name + ", todos=" + todos + ", isDone=" + isDone + ", targetDate="
				+ targetDate + "]";
	}
	
}
