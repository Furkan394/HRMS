package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"Job advertisements have been listed.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActive() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActive(),"Active job advertisements have been listed");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveAndPostedDate() {
		Sort sort = Sort.by(Sort.Direction.ASC,"postedDate");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort),"All active job advertisements have been listed by date.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployer_CompanyName(String companyName) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployer_CompanyName(companyName),"All active job advertisements belonging to the company have been listed");
	}
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job advertisement has been added.");
	}

	//update işlemi yapılacak
	
	/*
	 * @Override public Result update(JobAdvertisement jobAdvertisement) {
	 * 
	 * return null; }
	 */

}
