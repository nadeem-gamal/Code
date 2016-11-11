package edu.electronics.dal.orm;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class LED extends BaseEntity {
	private int id;
	private int color;
	private float voltage;
	private int numberOfPieces;
	private int numberOfUsedPieces;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ledRaw_seq")
	@SequenceGenerator(name = "ledRaw_seq", sequenceName = "LED_ID_SEQ")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	@Basic
	@Column
	public float getVoltage() {
		return voltage;
	}

	public void setVoltage(float voltage) {
		this.voltage = voltage;
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
}