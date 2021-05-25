package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;


@Service
public class JobTitleManager implements JobTitleService{

	@Autowired
	private JobTitleDao jobTitleDao;
	
	public JobTitleManager() {}
	
	@Override
	public DataResult<List<JobTitle>> getAll() {
		
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(),"Job titles listed");
	}

	@Override
	public Result add(JobTitle jobTitle) {
		if (getByTitle(jobTitle.getTitle()).getData() != null) {
			return new ErrorResult("This title already exists");
		}
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("Job title added");
	}

	@Override
	public DataResult<JobTitle> getByTitle(String title) {
		return new SuccessDataResult<JobTitle>(this.jobTitleDao.findByTitle(title));
	}

}
