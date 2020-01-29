package org.indigenous.pt.converter;

import org.indigenous.pt.model.Project;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ProjectConverter {

	public Project convertToModel(org.indigenous.pt.entity.Project project) {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(project, Project.class);
	}
	
	public org.indigenous.pt.entity.Project convertToEntity(Project project) {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(project, org.indigenous.pt.entity.Project.class);
	}
}
