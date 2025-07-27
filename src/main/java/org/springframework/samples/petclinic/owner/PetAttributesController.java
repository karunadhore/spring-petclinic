package org.springframework.samples.petclinic.owner;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.dto.PetAttributeResponseDto;
import org.springframework.samples.petclinic.dto.PetAttributesRequestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

/**
 * @author Karuna
 */

@RestController
@RequestMapping("/owners/{ownerId}/pets-attributes")
public class PetAttributesController {

	@Autowired
	private PetAttributesService petAttribtesService;

	@GetMapping("/{petId}")
	public ResponseEntity<?> getAttributes(@PathVariable int ownerId, @PathVariable int petId) {
		PetAttributeResponseDto attributes = petAttribtesService.getAttributesByPetId(ownerId, petId);
		return ResponseEntity.ok(attributes);
	}

	@PostMapping("/{petId}")
	public ResponseEntity<?> createAttribute(@PathVariable int ownerId, @PathVariable int petId,
			@Valid @RequestBody PetAttributesRequestDto attribute) {
		petAttribtesService.saveAttribute(ownerId, petId, attribute);
		Map<String, String> success = new HashMap<>();
		success.put("message", "Attribute saved successfully.");
		return ResponseEntity.status(HttpStatus.CREATED).body(success);
	}
}
