package model;

import java.sql.Date;
import java.sql.Timestamp;

public class Memo {
	private int index;
	private String author;
	private String content;
	private Timestamp datetime;
	
	public Memo() {
		
	}
	
	public Memo(String author, String content) {
		this.author = author;
		this.content = content;
	}
	
	public Memo(int index, String author, String content) {
		this.index = index;
		this.author = author;
		this.content = content;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}
	
}
