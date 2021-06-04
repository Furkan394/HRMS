package kodlamaio.hrms.entities.dtos;

import java.util.List;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.concretes.CvImage;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;
import kodlamaio.hrms.entities.concretes.ForeignLanguageLevel;
import kodlamaio.hrms.entities.concretes.ProgrammingTechnology;
import kodlamaio.hrms.entities.concretes.SchoolCandidate;
import kodlamaio.hrms.entities.concretes.SocialMedia;
import kodlamaio.hrms.entities.concretes.WorkplaceExperience;

public class CvDto {
	
	public Candidate candidate;
	public List<CoverLetter> coverLetters;
	public List<ForeignLanguage> foreignLanguages;
	public List<ForeignLanguageLevel> foreignLanguageLevels;
	public List<ProgrammingTechnology> programmingTechnologies;
	public List<SchoolCandidate> schoolCandidates;
	public List<SocialMedia> socialMedias;
	public List<WorkplaceExperience> workplaceExperiences;
	public CvImage cvImage;
	
}
