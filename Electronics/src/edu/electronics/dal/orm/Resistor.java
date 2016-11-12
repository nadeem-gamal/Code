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
public class Resistor extends BaseEntity {
	private int id;
	private int value;
	private int numberOfPieces;
	private int numberOfUsedPieces;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resistorRaw_seq")
	@SequenceGenerator(name = "resistorRaw_seq", sequenceName = "RESISTOR_ID_SEQ")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
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

	@Transient
	public int getPercentageOfUsedPieces() {
		try {
			return (numberOfUsedPieces * 100 / numberOfPieces);
		} catch (Exception e) {
			return 0;
		}
	}
}
