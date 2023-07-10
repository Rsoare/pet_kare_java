package com.java_projects.pet_kare_java.service;

import com.java_projects.pet_kare_java.dto.GroupDto;
import com.java_projects.pet_kare_java.exception.AppException;
import com.java_projects.pet_kare_java.model.Group;
import com.java_projects.pet_kare_java.repository.GroupRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group createGroup(final GroupDto groupData){
        final Group newGroup = new Group(groupData.getScientific_name());

        return groupRepository.save(newGroup);
    }

    public List<Group> getGroup(){return groupRepository.findAll();}

    public Group retrieveGroup(final long id){
        return groupRepository.findById(id).orElseThrow(() -> new AppException("pet not found", HttpStatus.NOT_FOUND));
    }

    public Group updateGroup(GroupDto groupData, final long id){

        final Group getGroup = groupRepository.findById(id).orElseThrow(() -> new AppException("Group not found", HttpStatus.NOT_FOUND));

        getGroup.setScientific_name(groupData.getScientific_name());

        return groupRepository.save(getGroup);
    }

    public void deleteGroup(final long id){
        final Group getGroup = groupRepository.findById(id).orElseThrow(() -> new AppException("Group not found", HttpStatus.NOT_FOUND));

        groupRepository.delete(getGroup);
    }
}
