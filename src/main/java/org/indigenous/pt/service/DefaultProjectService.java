package org.indigenous.pt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.indigenous.pt.converter.ProjectConverter;
import org.indigenous.pt.model.Project;
import org.indigenous.pt.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

@Service
public class DefaultProjectService implements ProjectService {

	@Resource
	private ProjectRepository projectRepository;

	@Resource
	private ProjectConverter projectConverter;

	@Resource
	private DatabaseCreationService mariaDBDatabaseCreationService;

	public void createProject(Project project) {
		projectRepository.save(projectConverter.convertToEntity(project));
	}

	public boolean validateProject(Project project) {
		org.indigenous.pt.entity.Project existing = projectRepository.findByShortName(project.getShortName());
		CompletableFuture.runAsync(new Runnable() {

			@Override
			public void run() {
				mariaDBDatabaseCreationService.createDatabase(project.getShortName());
			}
		});
		return existing != null;
	}

	public List<Project> listProjects() {
		return Lists.newArrayList(projectRepository.findAll()).stream().map(p -> {
			return projectConverter.convertToModel(p);
		}).collect(Collectors.toList());
	}
}
