package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;


public interface CandidateService {
	DataResult<List<Candidate>> getAll();
	DataResult<Candidate> getByIdentityNumber(String identityNumber);
	DataResult<Candidate> getByEmail(String email);
	Result add(Candidate candidate);
}
