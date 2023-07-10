package com.java_projects.pet_kare_java.controller;

import com.java_projects.pet_kare_java.dto.TraitDto;
import com.java_projects.pet_kare_java.model.Trait;
import com.java_projects.pet_kare_java.service.TraitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/traits")
public class TraitController {
    private final TraitService traitService;

    public TraitController(TraitService traitService) {
        this.traitService = traitService;
    }

    @PostMapping
    public ResponseEntity<Trait> createGroup(@RequestBody TraitDto traitData){

        final Trait newTrait = traitService.createTrait(traitData);

        return new ResponseEntity<>(newTrait, HttpStatus.CREATED);
    }
}
