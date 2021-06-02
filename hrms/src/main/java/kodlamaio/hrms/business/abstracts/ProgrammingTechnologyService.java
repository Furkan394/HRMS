package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ProgrammingTechnology;

public interface ProgrammingTechnologyService {

	DataResult<List<ProgrammingTechnology>> getAll();
	Result add(ProgrammingTechnology programmingTechnology);
}
