package application;

import java.io.Serializable;

/*
Thaddeus Albert Bartz
William Christian Leonard
Period 5
PSET6-0 SuperProject
February 12, 2018
*/

public class VetStatus implements Serializable{

	private static final long serialVersionUID = 1L;
	private String animalStatus;
	private String animalNotes;
	private String doctorName;
	private String vetName;
	private String vetLocation;
	
	//Default
	public VetStatus() {
		this.animalStatus = "Not Given";
		this.animalNotes = "Not Given";
		this.doctorName = "Not Given";
		this.vetName = "Not Given";
		this.vetLocation = "Not Given";
	}
	//Full
	public VetStatus(String animalStatus, String animalNotes, String doctorName, String vetName, String vetLocation) {
		this.animalStatus = animalStatus;
		this.animalNotes = animalNotes;
		this.doctorName = doctorName;
		this.vetName = vetName;
		this.vetLocation = vetLocation;
	}
	//No Doctors Credentials
	public VetStatus(String animalStatus, String animalNotes) {
		this.animalStatus = animalStatus;
		this.animalNotes = animalNotes;
		this.doctorName = "Not Given";
		this.vetName = "Not Given";
		this.vetLocation = "Not Given";
	}
	public String getAnimalStatus() {
		return animalStatus;
	}
	public void setAnimalStatus(String animalStatus) {
		this.animalStatus = animalStatus;
	}
	public String getAnimalNotes() {
		return animalNotes;
	}
	public void setAnimalNotes(String animalNotes) {
		this.animalNotes = animalNotes;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getVetName() {
		return vetName;
	}
	public void setVetName(String vetName) {
		this.vetName = vetName;
	}
	public String getVetLocation() {
		return vetLocation;
	}
	public void setVetLocation(String vetLocation) {
		this.vetLocation = vetLocation;
	}
	
}
