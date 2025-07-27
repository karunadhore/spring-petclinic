package org.springframework.samples.petclinic.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * @author Karuna
 */
public class PetAttributesRequestDto {

    @NotBlank(message = "Attribute name is required")
	private String attributeName;

    @NotBlank(message = "Attribute value is required")
	private String attributeValue;

	public PetAttributesRequestDto(String name, String value) {
		this.attributeName = name;
		this.attributeValue = value;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String name) {
		this.attributeName = name;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String value) {
		this.attributeValue = value;
	}

}
