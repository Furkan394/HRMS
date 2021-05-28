package kodlamaio.hrms.core.adapters.abstracts;

import java.time.LocalDate;

public interface FakeMernisService {
	boolean checkIfRealPerson(String firstName, String lastName, String identityNumber, LocalDate birthDate);
}
