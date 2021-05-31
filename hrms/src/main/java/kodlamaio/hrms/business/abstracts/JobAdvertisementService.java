package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
	
	Result add(JobAdvertisement jobAdvertisement);
	Result delete(int id);
	
	DataResult<JobAdvertisement> findById(int id);
	DataResult<List<JobAdvertisementDto>> findByIsActive();
	DataResult<List<JobAdvertisementDto>> findByIsActiveAndApplicationDeadline();
	DataResult<List<JobAdvertisementDto>> findByIsActiveAndCompanyName(String companyName);
	
}
