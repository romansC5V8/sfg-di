package com.springframework.pets;

// --> Dies ist deshalb auskommentiert, um zu "simulieren", dass diese 3rd-party-Klassen sind. Wir arbeiten mit Java Configuration
//@Profile({"dog", "default"})
//@Service
public class DogPetService implements PetService {

	@Override
	public String getPetType() {
		return "Dogs are the best!";
	}
}
