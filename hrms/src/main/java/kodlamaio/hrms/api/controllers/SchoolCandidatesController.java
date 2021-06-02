package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SchoolCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SchoolCandidate;

@RestController
@RequestMapping("/api/school-candidates")
public class SchoolCandidatesController {

	private SchoolCandidateService schoolCandidateService;
	
	@Autowired
	public SchoolCandidatesController(SchoolCandidateService schoolCandidateService) {
		super();
		this.schoolCandidateService = schoolCandidateService;
	}

	@GetMapping("/getall")
	public DataResult<List<SchoolCandidate>> getAll() { 
		return this.schoolCandidateService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SchoolCandidate schoolCandidate) {
		return this.schoolCandidateService.add(schoolCandidate);
	}
}