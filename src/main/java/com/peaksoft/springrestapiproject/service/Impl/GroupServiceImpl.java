
package com.peaksoft.springrestapiproject.service.Impl;


import com.peaksoft.springrestapiproject.converter.group.GroupRequestConverter;
import com.peaksoft.springrestapiproject.converter.group.GroupResponseConverter;
import com.peaksoft.springrestapiproject.dto.request.GroupRequest;
import com.peaksoft.springrestapiproject.dto.responce.GroupResponse;
import com.peaksoft.springrestapiproject.entities.Course;
import com.peaksoft.springrestapiproject.entities.Group;
import com.peaksoft.springrestapiproject.repository.CourseRepository;
import com.peaksoft.springrestapiproject.repository.GroupRepository;
import com.peaksoft.springrestapiproject.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor

public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final CourseRepository courseRepository;
    private final GroupRequestConverter groupRequestConverter;
    private final GroupResponseConverter groupResponseConverter;



    @Override
    public List<GroupResponse> getAllListGroups() {
        return groupResponseConverter.view(groupRepository.findAll());
    }

    @Override
    public List<GroupResponse> getAllGroups(Long courseId) {
        return null;
    }

    @Override
    public List<GroupResponse> getAlGroups(Long courseId) {
        return groupResponseConverter.view(courseRepository.getReferenceById(courseId).getGroupList());
    }

    @Override
    public GroupResponse addGroup(Long courseId, GroupRequest groupRequest) {
        Course course = courseRepository.findById(courseId).get();
        Group group = groupRequestConverter.createGroup(groupRequest);
        course.addGroup(group);
        group.addCourse(course);
        groupRepository.save(group);
        return groupResponseConverter.viewGroup(group);

    }

    @Override
    public GroupResponse getGroupById(Long id) {
        Group group =  groupRepository.findById(id).get();
        return groupResponseConverter.viewGroup(group);
    }

    @Override
    public GroupResponse updateGroup(Long id, GroupRequest groupRequest) {
        Group group =  groupRepository.findById(id).get();
        groupRequestConverter.updateGroup(group,groupRequest);
        groupRepository.save(group);
        return groupResponseConverter.viewGroup(group);

    }

    @Override
    public GroupResponse deleteGroup(Long id) {
        Group group =  groupRepository.findById(id).get();

        for (Course c: group.getCourseList()) {
            c.getGroupList().remove(group);
        }
        group.setCourseList(null);
        groupRepository.delete(group);
        return groupResponseConverter.viewGroup(group);
    }



    @Override
    public void assignGroup(Long courseId, Long groupId) throws IOException {
        Group group = groupRepository.findById(groupId).get();
        Course course = courseRepository.findById(courseId).get();
        if (course.getGroupList() != null) {
            for (Group g : course.getGroupList()) {
                if (g.getId() == courseId) {
                    throw new IOException("This group already exists!");
                }
            }
        }
        group.addCourse(course);
        course.addGroup(group);
        courseRepository.save(course);
        groupRepository.save(group);
    }
}