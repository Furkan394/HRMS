package kodlamaio.hrms.core.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abstracts.FakeMernisService;

@Service
public class FakeMernisAdapter implements FakeMernisService{

	@Override
	public boolean checkIfRealPerson(String identityNumber) {
		if (identityNumber.length() != 11) {
			System.out.println("TC identity number must be 11 digits.");
			return false;
		}
		System.out.println("Mernis verification successful.");
		return true;
	}

}
