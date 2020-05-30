package com.javaegitimleri.petclinic.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaegitimleri.petclinic.model.Vet;


public interface VetRepository extends JpaRepository<Vet, Long> {
	
//<Vet, Long>  ile entity tipi : Vet , primary tipi yani id nin tipi Long  parametreleri alınır.
	
}
