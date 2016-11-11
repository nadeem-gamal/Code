package edu.electronics.dal.orm;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@SuppressWarnings("serial")
@Entity
public class SevenSegment extends BaseEntity {
	private int id;
	private int numberOfPieces;
	private int numberOfUsedPieces;

	private int type;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sevenSegmentRaw_seq")
	@SequenceGenerator(name = "sevenSegmentRaw_seq", sequenceName = "SEVEN_SEGMENT_ID_SEQ")
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
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
