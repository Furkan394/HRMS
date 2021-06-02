package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.WorkplaceExperience;

public interface WorkplaceExperienceDao extends JpaRepository<WorkplaceExperience, Integer>{

}
