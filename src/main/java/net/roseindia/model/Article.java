package net.roseindia.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table( name = "article" )
public class Article implements Serializable{

	private static final long serialVersionUID = 1983198743930507248L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY ) 
	@Column( name = "id" )
	private int id;	

	@Column( name= "title" )
	private String title;

	@Column( name = "content" )
	private String content;

	public int getId() {
		
		return id;
		
	}

	public void setId( int id ) {
		
		this.id = id;
		
	}

	public String getTitle() {
		
		return title;
		
	}

	public void setTitle( String title ) {
		
		this.title = title;
		
	}

	public String getContent() {
		
		return content;
		
	}

	public void setContent( String content ) {
		
		this.content = content;
		
	}	  

	
}
