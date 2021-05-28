package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.adapters.abstracts.EmailValidationService;
import kodlamaio.hrms.core.adapters.abstracts.EmployeeValidationService;
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
	private EmailValidationService emailValid;
	private EmployeeValidationService employeeValid;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, UserDao userDao, EmailValidationService emailValid, EmployeeValidationService employeeValid) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
		this.emailValid = emailValid;
		this.employeeValid = employeeValid;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Employers have been listed.");
	}

	@Override
	public Result add(Employer employer) {
		
		if (employer.getEmail() == null || employer.getEmail() == ""
				|| employer.getPassword() == null  || employer.getPassword() == "" 
				|| employer.getPasswordRepeat() == null  || employer.getPasswordRepeat() == "" 
				|| employer.getCompanyName() == null || employer.getCompanyName() == ""
				|| employer.getWebAddress() == null || employer.getWebAddress() == ""
				|| employer.getPhoneNumber() == null  || employer.getPhoneNumber() == ""
			) 
		{
			return new ErrorResult("All fields must be filled.");
		
		}if (!employer.getPassword().equals(employer.getPasswordRepeat())) {
			return new ErrorResult("Passwords do not match.");
		
		}if (!employer.getEmail().contains("@" + employer.getEmail().substring(employer.getEmail().indexOf("@") + 1))) {
			return new ErrorResult("An e-mail address with the same domain must be used.");
		
		}if (userDao.findByEmail(employer.getEmail()) != null) {
			return new ErrorResult("This email address is already in use.");
		
		}if (!emailValid.isEmailValid(employer.getEmail())) {
			return new ErrorResult("Invalid email.");
		
		}if (!employeeValid.isValidatedByEmployee(employer)) {
			return new ErrorResult("Your account has not yet been approved by the system employees.");
		
		}else {
			
			this.employerDao.save(employer);
			return new SuccessResult("Employer has been added.");
		}
			
	}

}
