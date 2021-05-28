package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getByIsActive();
	DataResult<List<JobAdvertisement>> getByIsActiveAndPostedDate();
	DataResult<List<JobAdvertisement>> getByEmployer_CompanyName(String companyName);
	Result add(JobAdvertisement jobAdvertisement);
	//Result update(JobAdvertisement jobAdvertisement);
}
