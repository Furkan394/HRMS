package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ProgrammingTechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ProgrammingTechnologyDao;
import kodlamaio.hrms.entities.concretes.ProgrammingTechnology;

@Service
public class ProgrammingTechnologyManager implements ProgrammingTechnologyService{

	private ProgrammingTechnologyDao programmingTechnologyDao;

	@Autowired
	public ProgrammingTechnologyManager(ProgrammingTechnologyDao programmingTechnologyDao) {
		super();
		this.programmingTechnologyDao = programmingTechnologyDao;
	}

	@Override
	public DataResult<List<ProgrammingTechnology>> getAll() {
		
		return new SuccessDataResult<List<ProgrammingTechnology>>(this.programmingTechnologyDao.findAll(),"Programming technologies listed.");
	}

	@Override
	public Result add(ProgrammingTechnology programmingTechnology) {
		this.programmingTechnologyDao.save(programmingTechnology);
		return new SuccessResult("Programming technology added");
	}

}

