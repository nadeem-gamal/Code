package edu.electronics.dal.orm;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class DipSwitch extends BaseEntity {

	private int id;
	private int numberOfPieces;
	private int numberOfUsedPieces;
	private int numberOfSwitches;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dipSwitchRaw_seq")
	@SequenceGenerator(name = "dipSwitchRaw_seq", sequenceName = "DIP_SWITCH_ID_SEQ")
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
	public int getNumberOfSwitches() {
		return numberOfSwitches;
	}

	public void setNumberOfSwitches(int numberOfSwitches) {
		this.numberOfSwitches = numberOfSwitches;
	}

}
