package com.java_projects.pet_kare_java.controller;

import com.java_projects.pet_kare_java.dto.PetDto;
import com.java_projects.pet_kare_java.model.Pet;
import com.java_projects.pet_kare_java.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;


    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public  ResponseEntity<Pet> createPet(@RequestBody PetDto petRequest){
        final Pet newPet = petService.createPet(petRequest);

        return new ResponseEntity<>(newPet, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Pet>> getPets(){
        final List<Pet> allPets = petService.getPets();

        return new ResponseEntity<>(allPets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> retrievePet(@PathVariable final String id){
        final Pet getPet = petService.retrievePet(Long.parseLong(id));

        return new ResponseEntity<>(getPet, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@RequestBody final PetDto petData, @PathVariable final String id){
        final Pet updatePet = petService.updatePet(petData,Long.parseLong(id));

        return new ResponseEntity<>(updatePet, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable final String id){
        petService.deletePet(Long.parseLong(id));

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
