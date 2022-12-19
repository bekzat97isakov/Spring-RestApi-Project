package com.peaksoft.springrestapiproject.service;

import com.peaksoft.springrestapiproject.dto.request.GroupRequest;
import com.peaksoft.springrestapiproject.dto.responce.GroupResponse;


import java.io.IOException;
import java.util.List;

public interface GroupService {
    List<GroupResponse> getAllListGroups();

    List<GroupResponse> getAllGroups(Long courseId);

    List<GroupResponse> getAlGroups(Long courseId);

    GroupResponse addGroup(Long id, GroupRequest groupRequest);

    GroupResponse getGroupById(Long id);

    GroupResponse updateGroup(Long id, GroupRequest groupRequest);

    GroupResponse deleteGroup(Long id);
    void assignGroup(Long courseId, Long groupId) throws IOException;
}