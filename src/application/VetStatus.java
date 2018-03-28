package application;

import java.io.Serializable;

/*
Thaddeus Albert Bartz
William Christian Leonard
Period 5
PSET6  -0 SuperProject
February 12, 2018
*/

//stores the animals doctor and their notes
public class VetStatus implements Serializable{

    //variable list
	private static final long serialVersionUID = 1L;
	private String animalStatus;
	private String animalNotes;
	private String doctorName;
	private String vetName;
	private String vetLocation;
	
	//Default
	public VetStatus() {
		this.animalStatus = "No Data Entered";
		this.animalNotes = "No Data Entered";
		this.doctorName = "No Data Entered";
		this.vetName = "No Data Entered";
		this.vetLocation = "No Data Entered";
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
		this.doctorName = "No Data Entered";
		this.vetName = "No Data Entered";
		this.vetLocation = "No Data Entered";
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
