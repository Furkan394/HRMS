package kodlamaio.hrms.core.adapters.abstracts;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployeeValidationService {
	boolean isValidatedByEmployee(Employer employer);
}
