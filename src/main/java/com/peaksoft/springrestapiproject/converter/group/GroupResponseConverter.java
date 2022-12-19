
package com.peaksoft.springrestapiproject.converter.group;

import com.peaksoft.springrestapiproject.dto.responce.GroupResponse;
import com.peaksoft.springrestapiproject.entities.Group;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupResponseConverter {
    public GroupResponse viewGroup(Group group){
        if (group==null){
            return null;
        }

        GroupResponse groupResponse = new GroupResponse();

        groupResponse.setId(group.getId());
        groupResponse.setGroupName(group.getGroupName());
        groupResponse.setDateOfStart(group.getDateOfStart());
        groupResponse.setImage(group.getImage());

        return groupResponse;
    }

    public List<GroupResponse> view(List<Group> groups){
        List<GroupResponse> groupResponses = new ArrayList<>();

        for (Group group: groups) {
            groupResponses.add(viewGroup(group));
        }

        return  groupResponses;
    }
}
