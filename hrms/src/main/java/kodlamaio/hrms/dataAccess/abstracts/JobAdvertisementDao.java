package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	List<JobAdvertisement> findByIsActive(boolean status);
	List<JobAdvertisement> findByIsActiveOrderByApplicationDeadline(boolean status);
	List<JobAdvertisement> findByIsActiveAndEmployer_CompanyName(boolean status, String companyName);
}
