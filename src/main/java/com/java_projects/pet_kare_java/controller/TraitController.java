package com.java_projects.pet_kare_java.controller;

import com.java_projects.pet_kare_java.dto.TraitDto;
import com.java_projects.pet_kare_java.model.Trait;
import com.java_projects.pet_kare_java.service.TraitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/traits")
public class TraitController {
    private final TraitService traitService;

    public TraitController(TraitService traitService) {
        this.traitService = traitService;
    }

    @PostMapping
    public ResponseEntity<Trait> createTrait(@RequestBody TraitDto traitData){

        final Trait newTrait = traitService.createTrait(traitData);

        return new ResponseEntity<>(newTrait, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Trait>> getTrait(){
        final List<Trait> allTrait =  traitService.getTrait();

        return new  ResponseEntity<>(allTrait, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Trait> retrieveTrait(@PathVariable final String id){
        final Trait findTrait = traitService.retrieveTrait(Long.parseLong(id));

        return new ResponseEntity<>(findTrait, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public  ResponseEntity<Trait> updateGroup(@RequestBody final TraitDto traitData, @PathVariable final String id){
        final Trait updateTrait = traitService.updateTrait(traitData,Long.parseLong(id));

        return new ResponseEntity<>(updateTrait,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable final String id){

        traitService.deleteTrait(Long.parseLong(id));

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
