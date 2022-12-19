
package com.peaksoft.springrestapiproject.controller;

import com.peaksoft.springrestapiproject.dto.request.GroupRequest;
import com.peaksoft.springrestapiproject.dto.responce.GroupResponse;
import com.peaksoft.springrestapiproject.entities.Group;
import com.peaksoft.springrestapiproject.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;
    @GetMapping("/getAll/{id}")
    public List<GroupResponse> getAllCourse(@PathVariable Long id){
        return groupService.getAllGroups(id);
    }

    @PostMapping("/save/{id}")
    public GroupResponse saveGroup(@PathVariable Group id, @RequestBody GroupRequest groupRequest)  {
        return groupService.addGroup(id.getId(), groupRequest);
    }

    @GetMapping("/findById/{id}")
    public GroupResponse findById(@PathVariable Long id){
        return groupService.getGroupById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public GroupResponse deleteById(@PathVariable Long id){
        return groupService.deleteGroup(id);
    }

    @PutMapping("/update/{id}")
    public GroupResponse updateCourse(@RequestBody GroupRequest groupRequest, @PathVariable Group id)  {
        return groupService.updateGroup(id.getId(), groupRequest);
    }
}
