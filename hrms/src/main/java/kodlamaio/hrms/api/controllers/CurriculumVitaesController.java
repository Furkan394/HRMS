package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;

@RestController
@RequestMapping("/api/curriculum-vitaes")
public class CurriculumVitaesController {

	private CurriculumVitaeService curriculumVitaeService;
	
	@Autowired
	public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
		super();
		this.curriculumVitaeService = curriculumVitaeService;
	}

	@GetMapping("/getall")
	public DataResult<List<CurriculumVitae>> getAll() { 
		return this.curriculumVitaeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CurriculumVitae curriculumVitae) {
		return this.curriculumVitaeService.add(curriculumVitae);
	}
}
