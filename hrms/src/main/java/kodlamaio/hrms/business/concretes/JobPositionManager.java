package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;


@Service
public class JobPositionManager implements JobPositionService{

	@Autowired
	private JobPositionDao jobPositionDao;
	
	public JobPositionManager() {}
	
	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Data listed");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if (getByTitle(jobPosition.getTitle()).getData() != null) {
			return new ErrorResult("This position already exists");
		}
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Job Position added");
	}

	@Override
	public DataResult<JobPosition> getByTitle(String title) {
		return new SuccessDataResult<>(this.jobPositionDao.findByTitle(title));
	}

}
