package com.springframework.pets;

// --> Dies ist deshalb auskommentiert, um zu "simulieren", dass diese 3rd-party-Klassen sind. Wir arbeiten mit Java Configuration
//@Profile("cat")
//@Service
public class CatPetService implements PetService {

	@Override
	public String getPetType() {
		return "Cats Are the Best!";
	}
}
