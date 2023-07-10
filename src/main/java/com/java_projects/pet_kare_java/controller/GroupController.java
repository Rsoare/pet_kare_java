package com.java_projects.pet_kare_java.controller;

import com.java_projects.pet_kare_java.dto.GroupDto;
import com.java_projects.pet_kare_java.model.Group;
import com.java_projects.pet_kare_java.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public ResponseEntity<Group> createGroup(@RequestBody GroupDto groupData){
        final Group newGroup = groupService.createGroup(groupData);

        return new ResponseEntity<>(newGroup, HttpStatus.CREATED);
    }
   @GetMapping
    public  ResponseEntity<List<Group>> getGroup(){
        final List<Group> allGroups = groupService.getGroup();

        return new ResponseEntity<>(allGroups, HttpStatus.OK);
   }

   @GetMapping("/{id}")
   public ResponseEntity<Group> retrieveGroup(@PathVariable final String id){
       final Group findGroup = groupService.retrieveGroup(Long.parseLong(id));

       return new ResponseEntity<>(findGroup, HttpStatus.OK);
   }



   @PatchMapping("/{id}")
    public  ResponseEntity<Group> updateGroup(@RequestBody final GroupDto groupData, @PathVariable final String id){
        final Group updateGroup = groupService.updateGroup(groupData,Long.parseLong(id));

        return new ResponseEntity<>(updateGroup,HttpStatus.OK);
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable final String id){

        groupService.deleteGroup(Long.parseLong(id));

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
}
