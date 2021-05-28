package kodlamaio.hrms.core.adapters.concretes;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abstracts.FakeMernisService;

@Service
public class FakeMernisAdapter implements FakeMernisService{

	@Override
	public boolean checkIfRealPerson(String firstName, String lastName, String identityNumber, LocalDate birthDate) {
		//mernis verification simulation
		return true;
	}

}
