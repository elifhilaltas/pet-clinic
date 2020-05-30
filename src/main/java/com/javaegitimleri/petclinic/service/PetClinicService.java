package com.javaegitimleri.petclinic.service;

import java.util.List;

import javax.validation.Valid;

import com.javaegitimleri.petclinic.exception.OwnerNotFoundException;
import com.javaegitimleri.petclinic.exception.VetNotFoundException;
import com.javaegitimleri.petclinic.model.Owner;
import com.javaegitimleri.petclinic.model.Vet;

public interface PetClinicService {
	List<Owner> findOwners();
	List<Owner> findOwners(String lastName);
	Owner findOwners(Long id) throws OwnerNotFoundException; 
	void createOwner(@Valid Owner owner);
	void update(Owner owner);
	void deleteOwner(Long id);
	
	//Spring data :
	
	List<Vet> findVets();
	Vet findVet(Long id) throws VetNotFoundException;
	
}
