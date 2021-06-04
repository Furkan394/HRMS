package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CvImageService;
import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CvImage;

@RestController
@RequestMapping("/api/cv-images")
public class CvImagesController {

	private CvImageService cvImageService;
	private CandidateService candidateService;
	
	@Autowired
	public CvImagesController(CvImageService cvImageService, CandidateService candidateService) {
		super();
		this.cvImageService = cvImageService;
		this.candidateService = candidateService;
	}

	@GetMapping("/getall")
	public DataResult<List<CvImage>> getAll() { 
		return this.cvImageService.getAll();
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "multipartFile") MultipartFile multipartFile){
		Candidate candidate = this.candidateService.getById(id).getData();
		CvImage cvImage = new CvImage();
		cvImage.setCandidate(candidate);
		return this.cvImageService.add(cvImage, multipartFile);
	}
}

