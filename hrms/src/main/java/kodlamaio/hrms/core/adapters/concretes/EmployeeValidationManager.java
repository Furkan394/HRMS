package kodlamaio.hrms.core.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abstracts.EmployeeValidationService;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployeeValidationManager implements EmployeeValidationService{

	@Override
	public boolean isValidatedByEmployee(Employer employer) {
		System.out.println(employer.getCompanyName() + " company has been approved by system employees.");
		return true;
	}

}
