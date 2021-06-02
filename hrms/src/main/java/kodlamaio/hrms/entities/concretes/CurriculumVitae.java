package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "curriculum_vitaes")
public class CurriculumVitae {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "school_candidate_id")
	private SchoolCandidate schoolCandidate;
	
	@ManyToOne
	@JoinColumn(name = "workplace_experience_candidate_id")
	private WorkplaceExperienceCandidate workplaceExperienceCandidate;
	
	@ManyToOne
	@JoinColumn(name = "programming_technology_id")
	private ProgrammingTechnology programmingTechnology;
	
	@ManyToOne
	@JoinColumn(name = "foreign_language_id")
	private ForeignLanguage foreignLanguage;
	
	@ManyToOne
	@JoinColumn(name = "foreign_language_level_id")
	private ForeignLanguageLevel foreignLanguageLevel;
	
	@ManyToOne
	@JoinColumn(name = "social_media_id")
	private SocialMedia socialMedia;
	
	@ManyToOne
	@JoinColumn(name = "cover_letter_id")
	private CoverLetter coverLetter;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
}
