package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Candidates listed");
	}

	@Override
	public Result add(Candidate candidate) {
		if (getByIdentityNumber(candidate.getIdentityNumber()).getData() != null) {
			return new ErrorResult("This candidate identification number already exists.");
		}else if (getByEmail(candidate.getEmail()).getData() != null) {
			return new ErrorResult("This email already exists.");
		}
		
		this.candidateDao.save(candidate);
		return new SuccessResult("Candidate added");
	}

	@Override
	public DataResult<Candidate> getByIdentityNumber(String identityNumber) {
		
		return new SuccessDataResult<>(this.candidateDao.findByIdentityNumber(identityNumber));
	}

	@Override
	public DataResult<Candidate> getByEmail(String email) {
		
		return new SuccessDataResult<>(this.candidateDao.findByEmail(email));
	}

}
