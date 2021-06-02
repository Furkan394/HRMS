package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ForeignLanguageLevel;

public interface ForeignLanguageLevelDao extends JpaRepository<ForeignLanguageLevel, Integer>{

}
