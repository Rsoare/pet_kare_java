package com.java_projects.pet_kare_java.service;

import com.java_projects.pet_kare_java.dto.PetDto;
import com.java_projects.pet_kare_java.exception.AppException;
import com.java_projects.pet_kare_java.model.Group;
import com.java_projects.pet_kare_java.model.Pet;
import com.java_projects.pet_kare_java.repository.GroupRepository;
import com.java_projects.pet_kare_java.repository.PetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PetService {
    private final PetRepository petRepository;
    private final GroupRepository groupRepository;

    public PetService(PetRepository petRepository, GroupRepository groupRepository) {
        this.petRepository = petRepository;
        this.groupRepository = groupRepository;
    }

    public Pet createPet(final PetDto petData){

        final Pet newPet = new Pet(petData.getName(),petData.getAge(),petData.getWeight(),
                petData.getSex(),petData.getGroup_id(),petData.getTraits_id());

        return petRepository.save(newPet);
    }

    public Pet retrievePet(final long id){

        return petRepository.findById(id).orElseThrow(() -> new AppException("pet not found", HttpStatus.NOT_FOUND));
    }

    public List<Pet> getPets(){
        return petRepository.findAll();
    }

    public Pet updatePet (PetDto petData, final long id){

        final Pet getPet = petRepository.findById(id).orElseThrow(() -> new AppException("pet not found", HttpStatus.NOT_FOUND));

        getPet.setName(petData.getName());
        getPet.setAge(petData.getAge());
        getPet.setSex(petData.getSex());
        getPet.setWeight(petData.getWeight());
        getPet.setGroup(petData.getGroup_id());
        getPet.setTraits(petData.getTraits_id());

        return petRepository.save(getPet);
    }

    public void  deletePet (final long id){
        final Pet getPet = petRepository.findById(id).orElseThrow(() -> new AppException("pet not found", HttpStatus.NOT_FOUND));

        petRepository.delete(getPet);
    }

}
