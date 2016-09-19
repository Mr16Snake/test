package ua.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Smartphone {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Brand brand;
	
	private String model;
	
	@Enumerated(EnumType.ORDINAL)
	private Material material;
	
	private boolean powerful;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private ScreenSize screenSize;
	
	private boolean frontCamera;
	
	private boolean mainCamera;
	
	private boolean microSD;
	
	private boolean batteryGood;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Budget budget;
	
	private String url;
	
	@Lob
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public boolean isPowerful() {
		return powerful;
	}

	public void setPowerful(boolean powerful) {
		this.powerful = powerful;
	}

	public ScreenSize getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(ScreenSize screenSize) {
		this.screenSize = screenSize;
	}

	public boolean isFrontCamera() {
		return frontCamera;
	}

	public void setFrontCamera(boolean frontCamera) {
		this.frontCamera = frontCamera;
	}

	public boolean isMainCamera() {
		return mainCamera;
	}

	public void setMainCamera(boolean mainCamera) {
		this.mainCamera = mainCamera;
	}

	public boolean isMicroSD() {
		return microSD;
	}

	public void setMicroSD(boolean microSD) {
		this.microSD = microSD;
	}

	public boolean isBatteryGood() {
		return batteryGood;
	}

	public void setBatteryGood(boolean batteryGood) {
		this.batteryGood = batteryGood;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Smartphone [id=" + id + ", brand=" + brand + ", model=" + model
				+ "]";
	}
	
}
