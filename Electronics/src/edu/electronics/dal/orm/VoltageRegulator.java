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
public class VoltageRegulator extends BaseEntity {

	private int id;
	private int numberOfPieces;
	private int numberOfUsedPieces;

	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voltageRequlatorRaw_seq")
	@SequenceGenerator(name = "voltageRequlatorRaw_seq", sequenceName = "VOLTAGE_REGULATOR_ID_SEQ")
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
