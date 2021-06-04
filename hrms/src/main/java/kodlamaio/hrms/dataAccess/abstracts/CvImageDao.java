package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CvImage;

public interface CvImageDao extends JpaRepository<CvImage, Integer>{

}
