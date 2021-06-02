package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkplaceExperienceCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkplaceExperienceCandidateDao;
import kodlamaio.hrms.entities.concretes.WorkplaceExperienceCandidate;

@Service
public class WorkplaceExperienceCandidateManager implements WorkplaceExperienceCandidateService{
	
	private WorkplaceExperienceCandidateDao workplaceExperienceCandidateDao;

	@Autowired
	public WorkplaceExperienceCandidateManager(WorkplaceExperienceCandidateDao workplaceExperienceCandidateDao) {
		super();
		this.workplaceExperienceCandidateDao = workplaceExperienceCandidateDao;
	}

	@Override
	public DataResult<List<WorkplaceExperienceCandidate>> getAll() {
		
		return new SuccessDataResult<List<WorkplaceExperienceCandidate>>(this.workplaceExperienceCandidateDao.findAll(),"Workplace experience candidates listed.");
	}

	@Override
	public Result add(WorkplaceExperienceCandidate workplaceExperienceCandidate) {
		this.workplaceExperienceCandidateDao.save(workplaceExperienceCandidate);
		return new SuccessResult("Workplace experience candidate added");
	}

}
