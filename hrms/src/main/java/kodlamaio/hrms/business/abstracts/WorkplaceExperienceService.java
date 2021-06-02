package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkplaceExperience;

public interface WorkplaceExperienceService {

	DataResult<List<WorkplaceExperience>> getAll();
	Result add(WorkplaceExperience workplaceExperience);
}
