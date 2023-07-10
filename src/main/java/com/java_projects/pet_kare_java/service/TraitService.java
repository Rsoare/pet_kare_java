package com.java_projects.pet_kare_java.service;

import com.java_projects.pet_kare_java.dto.TraitDto;
import com.java_projects.pet_kare_java.exception.AppException;
import com.java_projects.pet_kare_java.model.Trait;
import com.java_projects.pet_kare_java.repository.TraitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraitService {

    private TraitRepository traitRepository;

    public TraitService(TraitRepository traitRepository) {
        this.traitRepository = traitRepository;
    }

    public Trait createTrait (final TraitDto traitData){

        final Trait newTrait = new Trait(traitData.getName());

        return traitRepository.save(newTrait);
    }

    public List<Trait> getTrait(){return traitRepository.findAll();}

    public Trait retrieveTrait(final long id){
        return traitRepository.findById(id).orElseThrow(() -> new AppException("Trait not found", HttpStatus.NOT_FOUND));
    }

    public  Trait updateTrait(TraitDto traitData, final long id){

        final Trait findTrait = traitRepository.findById(id).orElseThrow(() -> new AppException("Trait not found", HttpStatus.NOT_FOUND));

        findTrait.setName(traitData.getName());

        return traitRepository.save(findTrait);
    }

    public void deleteTrait(final long id){

        final Trait findTrait = traitRepository.findById(id).orElseThrow(() -> new AppException("Trait not found", HttpStatus.NOT_FOUND));

        traitRepository.delete(findTrait);
    }
}
