package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ForeignLanguageLevelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ForeignLanguageLevelDao;
import kodlamaio.hrms.entities.concretes.ForeignLanguageLevel;

@Service
public class ForeignLanguageLevelManager implements ForeignLanguageLevelService{

	private ForeignLanguageLevelDao foreignLanguageLevelDao;

	@Autowired
	public ForeignLanguageLevelManager(ForeignLanguageLevelDao foreignLanguageLevelDao) {
		super();
		this.foreignLanguageLevelDao = foreignLanguageLevelDao;
	}

	@Override
	public DataResult<List<ForeignLanguageLevel>> getAll() {
		
		return new SuccessDataResult<List<ForeignLanguageLevel>>(this.foreignLanguageLevelDao.findAll(),"Foreign language levels listed.");
	}

	@Override
	public Result add(ForeignLanguageLevel foreignLanguageLevel) {
		this.foreignLanguageLevelDao.save(foreignLanguageLevel);
		return new SuccessResult("Foreign language level added");
	}

}

