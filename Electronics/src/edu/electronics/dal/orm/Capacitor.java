package edu.electronics.dal.orm;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Capacitor extends BaseEntity {
	private int id;
	private float value;
	private int numberOfPieces;
	private int numberOfUsedPieces;
	private int type;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "capacitorRaw_seq")
	@SequenceGenerator(name = "capacitorRaw_seq", sequenceName = "CAPACITOR_ID_SEQ")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column
	public float getValue() {
		return value;
	}

	public void setValue(float value) {
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

	@Basic
	@Column
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
