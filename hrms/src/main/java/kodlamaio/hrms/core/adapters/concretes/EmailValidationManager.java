package kodlamaio.hrms.core.adapters.concretes;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abstracts.EmailValidationService;

@Service
public class EmailValidationManager implements EmailValidationService{

	@Override
	public boolean isEmailValid(String email) {
		final Pattern EMAIL_REGEX = Pattern.compile
				("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
						Pattern.CASE_INSENSITIVE);
		return EMAIL_REGEX.matcher(email).matches();
	}

	@Override
	public boolean isEmailValidOnClicked(String email) {
		System.out.println("Verification successful");
		return true;
	}

}
