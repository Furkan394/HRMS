package kodlamaio.hrms.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "curriculumVitaes"})
@Table(name = "programming_technologies")
public class ProgrammingTechnology {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "programming_technology_name")
	private String programmingTechonologyName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "programmingTechnology")
	private List<CurriculumVitae> curriculumVitaes;
	
}