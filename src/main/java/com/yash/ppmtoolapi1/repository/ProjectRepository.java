package com.yash.ppmtoolapi1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.ppmtoolapi1.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

	@Override
	Iterable<Project> findAllById(Iterable<Long> ids);
	
	Project findByProjectIdentifier(String projectId);
	
	@Override
	Iterable<Project> findAll();
}
