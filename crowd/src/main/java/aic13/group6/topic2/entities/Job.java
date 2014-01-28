package aic13.group6.topic2.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import aic13.group6.topic2.daos.DAORating;
import aic13.group6.topic2.pojos.State;

@XmlRootElement(name="job")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Job {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private long date;
	private State state;
	@ManyToMany
	private List<Article> articles;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public State getState() {
		return state;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public List<Article> getArticles() {
		return articles;
	}
	
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	@Transient
	@XmlAttribute
	public Double getRatingResult() {
		DAORating daoRating = new DAORating();
		return daoRating.calculateRatingResultForJob(this);
	}
	
}
