package edu.electronics.dal.orm;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
public class Diode extends BaseEntity {
	private int id;
	private int numberOfPieces;
	private int numberOfUsedPieces;

	private String description;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "diodeRaw_seq")
	@SequenceGenerator(name = "diodeRaw_seq", sequenceName = "DIODE_ID_SEQ")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column
	public int getNumberOfPieces() {
		return numberOfPieces;
	}

	public void setNumberOfPieces(int numberOfPieces) {
		this.numberOfPieces = numberOfPieces;
	}

	@Basic
	@Column
	public int getNumberOfUsedPieces() {
		return numberOfUsedPieces;
	}

	public void setNumberOfUsedPieces(int numberOfUsedPieces) {
		this.numberOfUsedPieces = numberOfUsedPieces;
	}

	@Basic
	@Column
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Transient
	public int getPercentageOfUsedPieces() {
		try {
			return (numberOfUsedPieces * 100 / numberOfPieces);
		} catch (Exception e) {
			return 0;
		}
	}

}
