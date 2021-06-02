package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkplaceExperienceCandidate;

public interface WorkplaceExperienceCandidateService {

	DataResult<List<WorkplaceExperienceCandidate>> getAll();
	Result add(WorkplaceExperienceCandidate workplaceExperienceCandidate);
}
