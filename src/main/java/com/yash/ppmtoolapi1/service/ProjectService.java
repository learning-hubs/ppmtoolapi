package com.yash.ppmtoolapi1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ppmtoolapi1.domain.Project;
import com.yash.ppmtoolapi1.exception.ProjectIdException;
import com.yash.ppmtoolapi1.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepository;
	
	public Project saveOrUpdateProject(Project project) {
		try {
			return projectRepository.save(project);
		} catch(Exception ex) {
			throw new ProjectIdException("Project Id '"+project.getProjectIdentifier().toUpperCase()+"' already exists");
		}
	}
	
	public Project findProjectByIdentifier(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId);
		if(project == null) {
			throw new ProjectIdException("Project Id '"+projectId+"' does not exist");
		}
		return project;
	}
	
	public Iterable<Project> findAllProjects() {
		return projectRepository.findAll();
	}
	
	public void deleteProjectByIdentifier(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId);
		
		if(project==null) {
			throw new ProjectIdException("Cannot delete project wid id '"+projectId+"' this project does not exist");
		}
		
		projectRepository.delete(project);
	}
	
	
}
