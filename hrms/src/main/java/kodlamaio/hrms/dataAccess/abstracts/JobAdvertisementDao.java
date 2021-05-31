package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	JobAdvertisement findById(int id);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto"
			+ "(e.companyName, jt.title, j.numberOfOpenPositions, j.postedDate, j.applicationDeadline) "
			+ "From JobAdvertisement j Inner Join j.employer e Inner Join j.jobTitle jt where j.isActive=true ")
	List<JobAdvertisementDto> findByIsActive();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto" 
			+ "(e.companyName, jt.title, j.numberOfOpenPositions, j.postedDate, j.applicationDeadline)" 
			+ "From JobAdvertisement j Inner Join j.employer e Inner Join j.jobTitle jt where j.isActive=true Order By j.postedDate ASC")
	List<JobAdvertisementDto> findByIsActiveOrderByApplicationDeadline();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto" 
			+ "(e.companyName, jt.title, j.numberOfOpenPositions, j.postedDate, j.applicationDeadline)"
			+ "From JobAdvertisement j Inner Join j.employer e Inner Join j.jobTitle jt where e.companyName=:companyName And j.isActive=true")
	List<JobAdvertisementDto> findByIsActiveAndEmployer_CompanyName(String companyName);
}
