package java2.test;

import java.io.Serializable;

public class Event implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String time, place, content;

	public Event() {
		
	}

	public Event(String time, String place, String content) {
		setTime(time);
		setPlace(place);
		setContent(content);
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Event["+getTime()+", "+getPlace()+", "+getContent()+"]";
	}
}
