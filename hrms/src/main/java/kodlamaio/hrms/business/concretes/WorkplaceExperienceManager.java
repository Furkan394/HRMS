package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkplaceExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkplaceExperienceDao;
import kodlamaio.hrms.entities.concretes.WorkplaceExperience;

@Service
public class WorkplaceExperienceManager implements WorkplaceExperienceService{
	
	private WorkplaceExperienceDao workplaceExperienceDao;

	@Autowired
	public WorkplaceExperienceManager(WorkplaceExperienceDao workplaceExperienceDao) {
		super();
		this.workplaceExperienceDao = workplaceExperienceDao;
	}

	@Override
	public DataResult<List<WorkplaceExperience>> getAll() {
		
		return new SuccessDataResult<List<WorkplaceExperience>>(this.workplaceExperienceDao.findAll(),"Workplace experience listed.");
	}

	@Override
	public Result add(WorkplaceExperience workplaceExperience) {
		this.workplaceExperienceDao.save(workplaceExperience);
		return new SuccessResult("Workplace experience added");
	}

}
