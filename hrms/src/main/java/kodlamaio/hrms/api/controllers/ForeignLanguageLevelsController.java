package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ForeignLanguageLevelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ForeignLanguageLevel;

@RestController
@RequestMapping("/api/foreign-language-levels")
public class ForeignLanguageLevelsController {

	private ForeignLanguageLevelService foreignLanguageLevelService;
	
	@Autowired
	public ForeignLanguageLevelsController(ForeignLanguageLevelService foreignLanguageLevelService) {
		super();
		this.foreignLanguageLevelService = foreignLanguageLevelService;
	}

	@GetMapping("/getall")
	public DataResult<List<ForeignLanguageLevel>> getAll() { 
		return this.foreignLanguageLevelService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ForeignLanguageLevel foreignLanguageLevel) {
		return this.foreignLanguageLevelService.add(foreignLanguageLevel);
	}
}