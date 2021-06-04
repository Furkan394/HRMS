package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "candidates")
public class Candidate extends User{
	
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "identity_number")
	private String identityNumber;
	
	@Column(name = "birth_date")
	private LocalDate birthDate;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CoverLetter> coverLetters;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<ForeignLanguage> foreignLanguages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<ForeignLanguageLevel> foreignLanguageLevels;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<ProgrammingTechnology> programmingTechnologies;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<SchoolCandidate> schoolCandidates;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<SocialMedia> socialMedias;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<WorkplaceExperience> workplaceExperiences;
	
	@JsonIgnore
	@OneToOne(mappedBy = "candidate")
	private CvImage image;

}
