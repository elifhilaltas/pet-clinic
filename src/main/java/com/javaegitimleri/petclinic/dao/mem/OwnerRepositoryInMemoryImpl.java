package com.javaegitimleri.petclinic.dao.mem;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.javaegitimleri.petclinic.dao.OwnerRepository;
import com.javaegitimleri.petclinic.model.Owner;

@Repository
public class OwnerRepositoryInMemoryImpl implements OwnerRepository {

	private Map<Long,Owner> ownersMap =new HashMap<>();
	
	public OwnerRepositoryInMemoryImpl() {
		Owner owner1= new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Elif");
		owner1.setLastName("Tas");
		
		Owner owner2= new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Ahmet");
		owner2.setLastName("Gurbuz");
		
		Owner owner3 = new Owner();
		owner3.setId(3L);
		owner3.setFirstName("Gulbahar");
		owner3.setLastName("Tas");
		
		Owner owner4= new Owner();
		owner4.setId(4L);
		owner4.setFirstName("Meryem");
		owner4.setLastName("Tas");
		
		ownersMap.put(owner1.getId(), owner1);
		ownersMap.put(owner2.getId(), owner2);
		ownersMap.put(owner3.getId(), owner3);
		ownersMap.put(owner4.getId(), owner4);
		
	
	}
	
	
	@Override
	public List<Owner> findAll() {
		return new ArrayList<>(ownersMap.values()); // list dönmemiz gerektiği için arraylist yaratıp bu owner nesnelerini values metodundan dönen collectiona parametre olarak veririz
		
	}

	@Override
	public Owner findById(Long id) {
		return ownersMap.get(id);
		
	}

	@Override
	public List<Owner> findByLastName(String lastName) {
		return ownersMap.values().stream().filter(o->o.getLastName().equals(lastName)).collect(Collectors.toList());
	}

	@Override
	public void create(Owner owner) {
		owner.setId(new Date().getTime()); // bu şekilde şimdiki zamanın long olarak karşılığını veriyor o yüzden benzersiz or: 010520200509
		ownersMap.put(owner.getId(), owner);
	}

	@Override
	public Owner update(Owner owner) {
		ownersMap.replace(owner.getId(), owner);
		return owner;
	}

	@Override
	public void delete(Long id) {
		ownersMap.remove(id);
		
	}

}
