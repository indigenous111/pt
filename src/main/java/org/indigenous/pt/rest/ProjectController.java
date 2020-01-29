package org.indigenous.pt.rest;

import java.util.List;

import javax.annotation.Resource;

import org.indigenous.pt.model.Project;
import org.indigenous.pt.model.ProjectExists;
import org.indigenous.pt.service.ProjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prj")
public class ProjectController {

	@Resource
	private ProjectService projectService;

	@PostMapping("/create")
	@ResponseBody
	public ProjectExists create(@RequestBody Project project) {
		ProjectExists model = new ProjectExists();
		model.setExists(projectService.validateProject(project));
		if (!model.isExists()) {
			projectService.createProject(project);
		}
		return model;
	}
	
	@GetMapping("/list")
	@ResponseBody
	public List<Project> list() {
		return projectService.listProjects();
	}

}
