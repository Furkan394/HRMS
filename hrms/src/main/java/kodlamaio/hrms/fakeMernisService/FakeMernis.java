package kodlamaio.hrms.fakeMernisService;

import java.time.LocalDate;

public class FakeMernis {
	public boolean checkIfRealPerson(String firstName, String lastName, String identityNumber, LocalDate birthDate) {
		
		FakeMernis fakeMernis = new FakeMernis();
		return fakeMernis.checkIfRealPerson(firstName, lastName, identityNumber, birthDate);
	}
}
