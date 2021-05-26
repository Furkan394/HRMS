package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private UserDao userDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, UserDao userDao) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Employers have been listed");
	}

	@Override
	public Result add(Employer employer) {
		
		if (employer.getEmail() == null
				|| employer.getPassword() == null 
				|| employer.getPasswordRepeat() == null 
				|| employer.getCompanyName() == null
				|| employer.getWebAddress() == null
				|| employer.getPhoneNumber() == null ) {
			return new ErrorResult("All fields must be filled.");
		
		}else if (!employer.getPassword().equals(employer.getPasswordRepeat())) {
			return new ErrorResult("Passwords do not match.");
		
		}else if (!employer.getEmail().contains("@" + employer.getEmail().substring(employer.getEmail().indexOf("@") + 1))) {
			return new ErrorResult("An e-mail address with the same domain must be used.");
		
		}else if (userDao.findByEmail(employer.getEmail()) != null) {
			return new ErrorResult("This email address is already in use.");
		
		}else {
			employerDao.save(employer);
			return new SuccessResult("Employer has been added");
		}
			
	}

}
