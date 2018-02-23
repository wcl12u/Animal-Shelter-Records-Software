package application;

/*
Thaddeus Albert Bartz
William Christian Leonard
Period 5
PSET6-0 SuperProject
February 12, 2018
 */

import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

public class CellLayoutPersonnel extends Pane {

	private CellLayoutPersonnelController controller;
	private String name;
	private int age;
	private String address;
	private LocalDate dateOfBirth;
	private LocalDate dateOfEmployement;
	private double wage;
	private boolean isEmployed;
	private String employeeNotes;
	private Personnel personnel;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd, yyyy");

	public CellLayoutPersonnel(Personnel personnel) {
		Node view = null;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CellLayoutPersonnel.fxml"));
		fxmlLoader.setControllerFactory(new Callback<Class<?>, Object>() {
			@Override
			public Object call(Class<?> param) {
				return controller = new CellLayoutPersonnelController();
			}
		});
		try {
			view = (Node) fxmlLoader.load();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		getChildren().add(view);
		this.personnel = personnel;
		name = personnel.getPersonnelName();
		age = personnel.getPersonnelAge();
		address = personnel.getPersonnelAddress();
		dateOfBirth = personnel.getPersonnelDOB();
		dateOfEmployement = personnel.getPersonnelDOE();
		wage = personnel.getWage();
		isEmployed = personnel.getEmployed();
		employeeNotes = personnel.getEmployeeNotes();
	}

	public CellLayoutPersonnel() {
		Node view = null;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CellLayoutPersonnel.fxml"));
		fxmlLoader.setControllerFactory(new Callback<Class<?>, Object>() {
			@Override
			public Object call(Class<?> param) {
				return controller = new CellLayoutPersonnelController();
			}
		});
		try {
			view = (Node) fxmlLoader.load();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		getChildren().add(view);
	}
	
	public Personnel getPersonnel() {
		return personnel;
	}
	
	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public LocalDate getDateOfEmployement() {
		return dateOfEmployement;
	}

	public double getWage() {
		return wage;
	}

	public void setView() {
		controller.lblName.setText(name);
		controller.lblAge.setText(String.valueOf(age));
		controller.lblAddress.setText(address);
		controller.lblDateOfBirth.setText(String.valueOf(dateOfBirth.format(formatter)));
		controller.lblDateOfEmployement.setText(String.valueOf(dateOfEmployement.format(formatter)));
		controller.lblWage.setText(NumberFormat.getCurrencyInstance(Locale.US).format(wage) + "per hour");
		controller.lblIsEmployed.setText(String.valueOf(isEmployed).toUpperCase(Locale.US));
		controller.lblEmployeeNotes.setText(employeeNotes);
	}



}