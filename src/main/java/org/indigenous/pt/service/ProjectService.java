package org.indigenous.pt.service;

import java.util.List;

import org.indigenous.pt.model.Project;

public interface ProjectService {

	void createProject(Project project);
	
	boolean validateProject(Project project);
	
	List<Project> listProjects();
}
