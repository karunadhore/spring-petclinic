package org.springframework.samples.petclinic.dto;

import java.util.List;

/**
 * @author Karuna
 * 
 */
public class PetAttributeResponseDto {
	private Integer petId;
    private String petName;
    private List<PetAttributesRequestDto> attributes;

    public PetAttributeResponseDto(Integer petId, String petName, List<PetAttributesRequestDto> attributes) {
        this.petId = petId;
        this.petName = petName;
        this.attributes = attributes;
    }

	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public List<PetAttributesRequestDto> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<PetAttributesRequestDto> attributes) {
		this.attributes = attributes;
	}
    
    

}
