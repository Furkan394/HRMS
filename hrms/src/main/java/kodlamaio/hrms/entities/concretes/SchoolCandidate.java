package kodlamaio.hrms.entities.concretes;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "school_candidates")
public class SchoolCandidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne()
	@JoinColumn(name = "school_department_id")
	private SchoolDepartment schoolDepartment;

	@Column(name = "date_of_entry")
	private LocalDate dateOfEntry;
	
	
	@Column(name = "date_of_graduation")
	private LocalDate dateOfGraduation;
	
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
}
