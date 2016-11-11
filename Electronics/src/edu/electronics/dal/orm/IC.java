package edu.electronics.dal.orm;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class IC extends BaseEntity {
	private int id;
	private int numberOfPieces;
	private int numberOfUsedPieces;
	private String name;
	private String description;
	private int numberOfPins;

	// TODO:: determine image path or blob image in db
	private String image;
	// TODO:: determine data sheet path of file in db
	private String dataSheet;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "icRaw_seq")
	@SequenceGenerator(name = "icRaw_seq", sequenceName = "IC_ID_SEQ")
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
	public int getNumberOfPins() {
		return numberOfPins;
	}

	public void setNumberOfPins(int numberOfPins) {
		this.numberOfPins = numberOfPins;
	}

	@Basic
	@Column
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Basic
	@Column
	public String getDataSheet() {
		return dataSheet;
	}

	public void setDataSheet(String dataSheet) {
		this.dataSheet = dataSheet;
	}

}
