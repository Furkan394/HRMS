package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		if (jobAdvertisementDao.findById(jobAdvertisement.getId()) != null) {
			return new ErrorResult("this job advertisement already exists.");
		}else {
			this.jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessResult("Job advertisement has been added.");
		}
		
	}

	@Override
	public Result delete(int id) {
		if (!findById(id).getData().isActive()) {
			this.jobAdvertisementDao.deleteById(id);
			return new SuccessResult("Job advertisement has been deleted.");
		}else {
			return new ErrorResult("Job advertisement could not be removed");
		}
		
	}
	
	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActive() {
		
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.findByIsActive(),"Active job advertisements have been listed");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActiveAndApplicationDeadline() {
		
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.findByIsActiveOrderByApplicationDeadline(),"All active job advertisements have been listed by date.");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActiveAndCompanyName(String companyName) {
		
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.findByIsActiveAndEmployer_CompanyName(companyName),"All active job advertisements belonging to the company have been listed");
	}

	@Override
	public DataResult<JobAdvertisement> findById(int id) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getOne(id));
	}

}
