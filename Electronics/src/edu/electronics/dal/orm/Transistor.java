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
public class Transistor extends BaseEntity {
	
	private int id;
	private int numberOfPieces;
	private int numberOfUsedPieces;

	private String description;

	private int type;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transistorRaw_seq")
	@SequenceGenerator(name = "transistorRaw_seq", sequenceName = "TRANSISTOR_ID_SEQ")
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

	@Basic
	@Column
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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
