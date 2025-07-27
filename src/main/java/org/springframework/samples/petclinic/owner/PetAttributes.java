package org.springframework.samples.petclinic.owner;

import org.springframework.samples.petclinic.model.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pet_attributes")
public class PetAttributes extends BaseEntity {

	/**
	 * @author Karuna
	 */
	@Column(name = "name")
	private String attributeName;

	@Column(name = "attribute_value")
	private String attributeValue;

	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

}
