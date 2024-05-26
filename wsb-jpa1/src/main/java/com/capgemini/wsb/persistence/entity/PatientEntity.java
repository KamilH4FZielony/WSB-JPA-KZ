package com.capgemini.wsb.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "PATIENT")
public class PatientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String telephoneNumber;

	private String email;

	@Column(nullable = false)
	private String patientNumber;

	@Column(nullable = false)
	private LocalDate dateOfBirth = LocalDate.of(1900, 1, 1); // Default date of birth

	@OneToMany(mappedBy = "patient")
	private Collection<VisitEntity> visits;

	@Column(nullable = false)
	private Integer age = 0; // Default age

	public PatientEntity() {
		// Default constructor
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCTOR_ID")
	private DoctorEntity doctor;

	// Constructor with all required fields
	public PatientEntity(String firstName, String lastName, String telephoneNumber, String patientNumber, LocalDate dateOfBirth, Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephoneNumber = telephoneNumber;
		this.patientNumber = patientNumber;
		this.dateOfBirth = dateOfBirth != null ? dateOfBirth : LocalDate.of(1900, 1, 1); // Ensure dateOfBirth is not null
		this.age = age != null ? age : 0; // Ensure age is not null
	}

	// Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth != null ? dateOfBirth : LocalDate.of(1900, 1, 1); // Ensure dateOfBirth is not null
	}

	public Collection<VisitEntity> getVisits() {
		return visits;
	}

	public void setVisits(Collection<VisitEntity> visits) {
		this.visits = visits;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age != null ? age : 0; // Ensure age is not null
	}
}
