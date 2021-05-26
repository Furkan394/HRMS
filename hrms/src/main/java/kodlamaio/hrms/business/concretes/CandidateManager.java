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
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private UserDao userDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserDao userDao) {
		super();
		this.candidateDao = candidateDao;
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Candidates listed");
	}

	@Override
	public Result add(Candidate candidate) {
		
		if( candidate.getEmail() == null 
				|| candidate.getPassword() == null 
				|| candidate.getPasswordRepeat() == null
				|| candidate.getFirstName() == null
				|| candidate.getLastName() == null
				|| candidate.getIdentityNumber() == null
				|| candidate.getBirthDate() == null ) {
			
			return new ErrorResult("All fields must be filled.");
		
		}else if (!candidate.getPassword().equals(candidate.getPasswordRepeat())) {
			return new ErrorResult("Passwords are incompatible.");
		
		}else if (userDao.findByEmail(candidate.getEmail()) != null) {
			return new ErrorResult("This email address is already in use.");
		
		}else if (candidateDao.findByIdentityNumber(candidate.getIdentityNumber()) != null) {
			return new ErrorResult("This identity number is already in use.");
		
		}else { 
			candidateDao.save(candidate);
			return new SuccessResult("Candidate added");
		}
			
	}

}
