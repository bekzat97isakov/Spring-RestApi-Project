package com.peaksoft.springrestapiproject.repository;

import com.peaksoft.springrestapiproject.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
