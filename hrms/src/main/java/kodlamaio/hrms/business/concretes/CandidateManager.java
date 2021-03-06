package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.adapters.abstracts.EmailValidationService;
import kodlamaio.hrms.core.adapters.abstracts.FakeMernisService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CvDto;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private UserDao userDao;
	private FakeMernisService fakeMernis;
	private EmailValidationService emailValid;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserDao userDao,
			FakeMernisService fakeMernis, EmailValidationService emailValid) {
		super();
		this.candidateDao = candidateDao;
		this.userDao = userDao;
		this.fakeMernis = fakeMernis;
		this.emailValid = emailValid;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Candidates listed.");
	}

	@Override
	public Result add(Candidate candidate) {
		
		if(candidate.getEmail() == null || candidate.getEmail() == "" 
				|| candidate.getPassword() == null || candidate.getPassword() == ""
				|| candidate.getPasswordRepeat() == null || candidate.getPasswordRepeat() == ""
				|| candidate.getFirstName() == null || candidate.getFirstName() == ""
				|| candidate.getLastName() == null || candidate.getLastName() == ""
				|| candidate.getIdentityNumber() == null || candidate.getIdentityNumber() == ""
				|| candidate.getBirthDate() == null) 
		{
			return new ErrorResult("All fields must be filled.");
		
		}if (!candidate.getPassword().equals(candidate.getPasswordRepeat())) {
			return new ErrorResult("Passwords do not match.");
		
		}if (userDao.findByEmail(candidate.getEmail()) != null) {
			return new ErrorResult("This email address is already in use.");
		
		}if (candidateDao.findByIdentityNumber(candidate.getIdentityNumber()) != null) {
			return new ErrorResult("This identity number is already in use.");
		
		}if (!fakeMernis.checkIfRealPerson(candidate.getFirstName(), candidate.getLastName(), candidate.getIdentityNumber(), candidate.getBirthDate())) {
			return new ErrorResult("Mernis validation failed.");
			
		}if (!emailValid.isEmailValid(candidate.getEmail())) {
				return new ErrorResult("Invalid email.");
				
		}if (!emailValid.isEmailValidOnClicked(candidate.getEmail())) {
				return new ErrorResult("Please click the verification link.");
				
		}else {
			
			this.candidateDao.save(candidate);
			return new SuccessResult("Candidate added.");
		}
	}

	@Override
	public DataResult<CvDto> getCvById(int id) {
		Candidate candidate = this.candidateDao.getById(id);
		CvDto cv = new CvDto();
		cv.coverLetters = candidate.getCoverLetters();
		cv.foreignLanguages = candidate.getForeignLanguages();
		cv.foreignLanguageLevels = candidate.getForeignLanguageLevels();
		cv.programmingTechnologies = candidate.getProgrammingTechnologies();
		cv.schoolCandidates = candidate.getSchoolCandidates();
		cv.socialMedias = candidate.getSocialMedias();
		cv.workplaceExperiences = candidate.getWorkplaceExperiences();
		cv.cvImage = candidate.getImage();
		return new SuccessDataResult<CvDto>(cv);
	}

	@Override
	public DataResult<Candidate> getById(int id) {

		return new SuccessDataResult<Candidate>(this.candidateDao.getById(id));
	}
}
