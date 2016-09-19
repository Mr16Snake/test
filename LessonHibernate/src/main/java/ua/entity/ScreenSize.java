package ua.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ScreenSize {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String value;
	
	@OneToMany(mappedBy="screenSize")
	private List<Smartphone> smartphones;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<Smartphone> getSmartphones() {
		return smartphones;
	}

	public void setSmartphones(List<Smartphone> smartphones) {
		this.smartphones = smartphones;
	}
	
	@Override
	public String toString() {
		return "Screen size [ " + id + ". " + value + " ]";
	}
}
