package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> findByIsActive();
	DataResult<List<JobAdvertisement>> findByIsActiveAndApplicationDeadline();
	DataResult<List<JobAdvertisement>> findByIsActiveAndCompanyName(String companyName);
	Result add(JobAdvertisement jobAdvertisement);
	Result delete(JobAdvertisement jobAdvertisement);
}
