package org.indigenous.pt.repository;

import org.indigenous.pt.entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{

	Project findByShortName(String shortName);
}
