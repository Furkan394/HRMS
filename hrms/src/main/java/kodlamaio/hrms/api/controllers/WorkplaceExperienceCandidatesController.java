package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkplaceExperienceCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkplaceExperienceCandidate;

@RestController
@RequestMapping("/api/workplace-experience-candidates")
public class WorkplaceExperienceCandidatesController {

	private WorkplaceExperienceCandidateService workplaceExperienceCandidateService;
	
	@Autowired
	public WorkplaceExperienceCandidatesController(WorkplaceExperienceCandidateService workplaceExperienceCandidateService) {
		super();
		this.workplaceExperienceCandidateService = workplaceExperienceCandidateService;
	}

	@GetMapping("/getall")
	public DataResult<List<WorkplaceExperienceCandidate>> getAll() { 
		return this.workplaceExperienceCandidateService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody WorkplaceExperienceCandidate workplaceExperienceCandidate) {
		return this.workplaceExperienceCandidateService.add(workplaceExperienceCandidate);
	}
}

