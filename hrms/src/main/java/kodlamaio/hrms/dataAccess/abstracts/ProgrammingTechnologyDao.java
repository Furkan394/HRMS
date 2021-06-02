package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ProgrammingTechnology;

public interface ProgrammingTechnologyDao extends JpaRepository<ProgrammingTechnology, Integer>{

}
