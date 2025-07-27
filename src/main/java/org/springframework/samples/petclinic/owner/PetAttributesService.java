package org.springframework.samples.petclinic.owner;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.dto.PetAttributeResponseDto;
import org.springframework.samples.petclinic.dto.PetAttributesRequestDto;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

/**
 * @author Karuna
 */

@Service
public class PetAttributesService {

	@Autowired
	private PetAttributesRepository petAttributesRepository;
	@Autowired
	private OwnerRepository ownerRepository;

	public void saveAttribute(int ownerId, int petId, PetAttributesRequestDto attributesDto) {
		Pet pet = findPetForOwner(ownerId, petId);
		PetAttributes attribute = new PetAttributes();
		attribute.setPet(pet);
		attribute.setAttributeName(attributesDto.getAttributeName());
		attribute.setAttributeValue(attributesDto.getAttributeValue());
		petAttributesRepository.save(attribute);
	}

	public PetAttributeResponseDto getAttributesByPetId(int ownerId, int petId) {
		Pet pet = findPetForOwner(ownerId, petId);
		List<PetAttributes> attributes = petAttributesRepository.findByPetId(pet.getId());
		List<PetAttributesRequestDto> attributeDtos = attributes.stream()
				.map(attr -> new PetAttributesRequestDto(attr.getAttributeName(), attr.getAttributeValue()))
				.collect(Collectors.toList());
		return new PetAttributeResponseDto(pet.getId(), pet.getName(), attributeDtos);
	}

	private Pet findPetForOwner(int ownerId, int petId) {
		Optional<Owner> optionalOwner = ownerRepository.findById(ownerId);
		Owner owner = optionalOwner.orElseThrow(() -> new EntityNotFoundException(
				"Owner not found with id: " + ownerId + ". Please ensure the ID is correct "));
		Pet pet = owner.getPets().stream().filter(p -> p.getId().equals(petId)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Pet does not belong to this owner"));
		return pet;

	}

}
