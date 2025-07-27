package org.springframework.samples.petclinic.owner;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Karuna
 */
@Repository
public interface PetAttributesRepository extends JpaRepository<PetAttributes, Integer>{
	 List<PetAttributes> findByPetId(int petId);

}
