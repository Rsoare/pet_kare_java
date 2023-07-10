package com.java_projects.pet_kare_java.service;

import com.java_projects.pet_kare_java.dto.PetDto;
import com.java_projects.pet_kare_java.exception.AppException;
import com.java_projects.pet_kare_java.model.Group;
import com.java_projects.pet_kare_java.model.Pet;
import com.java_projects.pet_kare_java.model.Trait;
import com.java_projects.pet_kare_java.repository.GroupRepository;
import com.java_projects.pet_kare_java.repository.PetRepository;
import com.java_projects.pet_kare_java.repository.TraitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PetService {
    private final PetRepository petRepository;
    private final GroupRepository groupRepository;

    private final TraitRepository traitRepository;

    public PetService(PetRepository petRepository, GroupRepository groupRepository, TraitRepository traitRepository) {
        this.petRepository = petRepository;
        this.groupRepository = groupRepository;
        this.traitRepository = traitRepository;
    }

    public Pet createPet(final PetDto petData){
        final long groupId = petData.getGroup_id();
        final long traitId = petData.getTrait_id();

        Group findGroup = null;
        Trait findTrait = null;

        if(groupId > 0 ){
            findGroup = groupRepository.findById(groupId).orElseThrow(() -> new AppException("Group not found", HttpStatus.NOT_FOUND));
        }

        if(traitId > 0){
            findTrait = traitRepository.findById(traitId).orElseThrow(() -> new AppException("Trait not found", HttpStatus.NOT_FOUND));
        }

        Set<Trait> traitsSet = new HashSet<>();
        traitsSet.add(findTrait);

        final Pet newPet = new Pet(petData.getName(),petData.getAge(),petData.getWeight(),
                petData.getSex(),findGroup,traitsSet);

        return petRepository.save(newPet);
    }

    public Pet retrievePet(final long id){

        return petRepository.findById(id).orElseThrow(() -> new AppException("pet not found", HttpStatus.NOT_FOUND));
    }

    public List<Pet> getPets(){
        return petRepository.findAll();
    }

    public Pet updatePet (PetDto petData, final long id){

        final long groupId = petData.getGroup_id();

        final Group findGroup = groupRepository.findById(groupId).orElseThrow(() -> new AppException("Group not found", HttpStatus.NOT_FOUND));

        final Pet getPet = petRepository.findById(id).orElseThrow(() -> new AppException("pet not found", HttpStatus.NOT_FOUND));

        getPet.setName(petData.getName());
        getPet.setAge(petData.getAge());
        getPet.setSex(petData.getSex());
        getPet.setWeight(petData.getWeight());
        getPet.setGroup(findGroup);

        return petRepository.save(getPet);
    }

    public void  deletePet (final long id){
        final Pet getPet = petRepository.findById(id).orElseThrow(() -> new AppException("pet not found", HttpStatus.NOT_FOUND));

        petRepository.delete(getPet);
    }

}
