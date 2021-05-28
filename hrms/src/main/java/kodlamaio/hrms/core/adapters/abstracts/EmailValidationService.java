package kodlamaio.hrms.core.adapters.abstracts;

public interface EmailValidationService {
	boolean isEmailValid(String email);
	boolean isEmailValidOnClicked(String email);
}
