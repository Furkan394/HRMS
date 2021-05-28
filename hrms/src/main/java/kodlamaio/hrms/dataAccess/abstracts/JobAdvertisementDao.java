package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	@Query("From JobAdvertisement where isActive=:true")
	List<JobAdvertisement> getByIsActive();
	
	@Query("From JobAdvertisement where isActive=:true")
	List<JobAdvertisement> getByIsActiveAndPostedDate();
	
	List<JobAdvertisement> getByEmployer_CompanyName(String companyName);
}
