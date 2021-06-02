package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SchoolCandidate;

public interface SchoolCandidateService {

	DataResult<List<SchoolCandidate>> getAll();
	Result add(SchoolCandidate schoolCandidate);
}
