package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CvDto;


public interface CandidateService {
	DataResult<List<Candidate>> getAll();
	Result add(Candidate candidate);
	
	DataResult<Candidate> getById(int id);
	DataResult<CvDto> getCvById(int id);
}
