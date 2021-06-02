package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.WorkplaceExperienceCandidate;

public interface WorkplaceExperienceCandidateDao extends JpaRepository<WorkplaceExperienceCandidate, Integer>{

}
